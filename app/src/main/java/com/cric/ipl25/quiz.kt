package com.cric.ipl25

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import com.airbnb.lottie.LottieAnimationView
import com.cric.ipl25.retrofit.questionsApi
import com.cric.ipl25.retrofit.retrofitInstance
import com.cric.ipl25.viewModel.QuizViewModel
import com.cric.ipl25.viewModel.QuizViewModelFactory
import com.crick.ipl25.R
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class quiz : AppCompatActivity() {

    lateinit var viewModel: QuizViewModel
    lateinit var fragmentAdapter: fragmentAdapter
    lateinit var quizArrayList: ArrayList<question>
    var count = 0
    var toast: Toast? = null
    lateinit var lottieAnimationView: LottieAnimationView
    private val handler = Handler(Looper.getMainLooper())
    private val toastRunnable: Runnable = object : Runnable {
        override fun run() {
            showToast()
            handler.postDelayed(this, 20000) // 20 seconds
        }
    }

    companion object {
        var result = 0
        var totalquestions = 0
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            val window=window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor=ContextCompat.getColor(this,R.color.status_bar_color)
        }

        val back: ImageButton = findViewById(R.id.backToMain)
        back.setOnClickListener {
            val i = Intent(this@quiz, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        val viewPager2: ViewPager2 = findViewById(R.id.viewPager)

        result = 0
        totalquestions = 0

        fetchBaseUrlAndInitRetrofit(viewPager2)
    }

    private fun fetchBaseUrlAndInitRetrofit(viewPager2: ViewPager2) {
        val db = FirebaseFirestore.getInstance()
        val docRef = db.collection("baseUrl").document("baseUrl")

        docRef.get()
            .addOnSuccessListener { documentSnapshot ->
                if (documentSnapshot.exists()) {
                    val baseUrl = documentSnapshot.getString("Url")
                    val ready = documentSnapshot.getBoolean("ready")
                    if (baseUrl != null) {
                        Log.d("FirestoreFetch", "Base URL: $baseUrl")
                        if (ready == true) {
                            initializeRetrofit(baseUrl, viewPager2)
                        } else {
                            showToast()
                            handler.post(toastRunnable)
                            // Show the host activation message TextView
                            findViewById<TextView>(R.id.hostActivationMessage).visibility = View.VISIBLE
                        }
                    } else {
                        Log.e("FirestoreFetch", "String field is null")
                    }
                } else {
                    Log.e("FirestoreFetch", "Document does not exist")
                }
            }
            .addOnFailureListener { exception ->
                Log.e("FirestoreFetch", "Error fetching document: $exception")
            }
    }

    private fun initializeRetrofit(baseUrl: String, viewPager2: ViewPager2) {
        val retrofitInstance = retrofitInstance()
        val retrofit = retrofitInstance.getRetrofitInstance(baseUrl)
        val questionsApi = retrofit.create(questionsApi::class.java)

        viewModel = ViewModelProvider(this, QuizViewModelFactory(questionsApi)).get(QuizViewModel::class.java)

        fragmentAdapter = fragmentAdapter(supportFragmentManager, lifecycle)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        GlobalScope.launch(Dispatchers.Main) {
            viewModel.getQuestionFromLiveData().observe(this@quiz) { questionList ->
                if (questionList != null && questionList.isNotEmpty()) {
                    quizArrayList = questionList
                    for (i in quizArrayList.indices) {
                        fragmentAdapter.addFragment(FragmentQuiz(quizArrayList[i], count))
                        count++
                        fragmentAdapter.notifyDataSetChanged()
                    }
                }
            }
        }
        viewPager2.adapter = fragmentAdapter
    }

    private fun showToast() {
        val layout = LayoutInflater.from(this).inflate(R.layout.toast_layout, null)
        lottieAnimationView = layout.findViewById(R.id.lottie_loading)
        lottieAnimationView.setAnimation(R.raw.error)
        lottieAnimationView.playAnimation()
        lottieAnimationView.loop(true)
        toast = Toast(applicationContext)
        toast?.setGravity(Gravity.CENTER, 0, 0)
        toast?.duration = Toast.LENGTH_LONG
        toast?.view = layout
        toast?.show()
    }

    override fun onDestroy() {
        super.onDestroy()
        handler.removeCallbacks(toastRunnable)
        toast?.cancel()
        lottieAnimationView.cancelAnimation()
    }
}
