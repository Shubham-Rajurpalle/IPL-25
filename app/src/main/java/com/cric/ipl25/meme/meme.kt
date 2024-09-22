package com.cric.ipl25.meme

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowManager
import android.widget.ImageButton
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.cric.ipl25.MainActivity
import com.cric.ipl25.MemeViewModel
import com.cric.ipl25.reportFragment
import com.crick.ipl25.R
import com.crick.ipl25.databinding.ActivityMemeBinding
import com.google.android.gms.ads.interstitial.InterstitialAd

class meme : AppCompatActivity(), reportFragment.ConfirmationListener {

    private var mInterstitialAd: InterstitialAd? = null
    private val TAG = "MemeActivity"

    val viewModel: MemeViewModel by viewModels()
    private lateinit var binding: ActivityMemeBinding
    private lateinit var memeAdapter: MemeAdapter
    private lateinit var memeList: MutableList<Meme_data>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_meme)
        memeList = mutableListOf()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        }

        val back = findViewById<ImageButton>(R.id.backtoMainA)
        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        //binding.recycleMeme.setHasFixedSize(true)
        binding.recycleMeme.layoutManager = LinearLayoutManager(this)

        binding.addMeme.setOnClickListener {
            val intent = Intent(this, memeAdd::class.java)
            startActivity(intent)
        }

        viewModel.memes.observe(this, Observer { memes ->
            memeList.clear()
            memeList.addAll(memes)
            memeAdapter.notifyDataSetChanged()
        })
        viewModel.loadMemes()

        if (memeList.isEmpty()){
            binding.listNoPost.visibility=View.VISIBLE
            binding.listNoPost.text="No post availble"
        }else{
            binding.listNoPost.visibility=View.GONE
        }

        viewModel.error.observe(this) { error ->
            if (error != null) {
                binding.listNoPost.visibility = View.VISIBLE
                binding.listNoPost.text = error
            } else {
                binding.listNoPost.visibility=View.GONE
            }

        }
        viewModel.actionListener = object : MemeViewModel.MemeActionListener {
            override fun showReportConfirmation(memeId: String, reportCount: Int) {
                val fragment = reportFragment().apply {
                    arguments = Bundle().apply {
                        putString("memeId", memeId)
                        putInt("reportCount",reportCount)
                    }
                }
                fragment.show(supportFragmentManager, "reportFragment")
            }
        }

        memeAdapter = MemeAdapter(this, memeList)
        binding.recycleMeme.adapter = memeAdapter

    }

    override fun onConfirmReport(memeId: String,reportCount:Int) {
        viewModel.reportMeme(memeId, reportCount)
    }
}