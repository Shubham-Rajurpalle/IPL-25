package com.cric.ipl25.chat

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crick.ipl25.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class chatN : AppCompatActivity(), ChatAdapter.ReportListener,
    reportFragmentChat.ReportConfirmationListener {

    private var mInterstitialAd: InterstitialAd? = null
    private val TAG = "chat_activity"

    private val viewModel: ChatViewModel by viewModels()
    private lateinit var recyclerView: RecyclerView
    private lateinit var chatAdapter: ChatAdapter
    private lateinit var teamId: String
    private lateinit var teamName: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        }

        MobileAds.initialize(this) { initializationStatus ->
            loadInterstitialAd()
        }

        teamId = intent.getStringExtra("teamId").orEmpty()
        teamName = intent.getStringExtra("teamName").orEmpty()

        recyclerView = findViewById(R.id.chatRecyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)
        chatAdapter = ChatAdapter(this, emptyList()) // Pass listener to adapter
        recyclerView.adapter = chatAdapter

        setupTeamData()
        setupSendButton()
        setupBackButton()

        viewModel.messages.observe(this, Observer { messages ->
            chatAdapter.setMessages(messages)
        })
    }

    override fun onReportConfirming(chatMessage: String, reportCount: Int) {
        val fragment = reportFragmentChat().apply {
            arguments = Bundle().apply {
                putString("ChatMessage", chatMessage)
                putInt("reportCount", reportCount)
            }
        }
        fragment.setReportConfirmationListener(this)
        fragment.show(supportFragmentManager, "reportFragmentChat")
    }

    override fun onReportConfirmed(chatId: String, reportCount: Int) {
        viewModel.updateReportCount(chatId, reportCount)
    }

    private fun setupTeamData() {
        val teamNameTextView = findViewById<TextView>(R.id.teamName)
        teamNameTextView?.let {
            it.text = teamName
            it.setBackgroundColor(getTeamColor(teamId))
        } ?: Log.e("ChatN", "TextView with ID teamName not found")
    }

    private fun getTeamColor(teamId: String): Int {
        return when (teamId) {
            "CSK" -> ContextCompat.getColor(this, R.color.cskColor)
            "RCB" -> ContextCompat.getColor(this, R.color.rcbColor)
            "MI" -> ContextCompat.getColor(this, R.color.miColor)
            "KKR" -> ContextCompat.getColor(this, R.color.kkrColor)
            "RR" -> ContextCompat.getColor(this, R.color.rrColor)
            "PK" -> ContextCompat.getColor(this, R.color.pkColor)
            "DC" -> ContextCompat.getColor(this, R.color.dcColor)
            "SH" -> ContextCompat.getColor(this, R.color.shColor)
            "LSG" -> ContextCompat.getColor(this, R.color.lsgColor)
            "GT" -> ContextCompat.getColor(this, R.color.gtColor)
            else -> ContextCompat.getColor(this, R.color.defaultColor)
        }
    }

    private fun setupSendButton() {
        val sendButton = findViewById<ImageView>(R.id.sendMessageButton)
        val messageEditText = findViewById<EditText>(R.id.messageEditText)

        sendButton.setOnClickListener {
            val messageText = messageEditText.text.toString().trim()
            if (messageText.isNotEmpty()) {
                val message = ChatMessage(
                    message = messageText,
                    senderId = teamId,
                    teamId = teamId,
                    timestamp = System.currentTimeMillis(),
                    reportCount = 0
                )
                viewModel.sendMessage(message)
                messageEditText.text.clear()
            }
        }
    }

    private fun setupBackButton() {
        val backButton = findViewById<ImageView>(R.id.back)
        backButton.setOnClickListener {
            onBackPressed()
        }
    }

    fun loadInterstitialAd() {
        val adRequest =AdRequest.Builder().build()
        InterstitialAd.load(this, "ca-app-pub-1572144131676861/8859972880", adRequest, object : InterstitialAdLoadCallback() {
            override fun onAdLoaded(interstitialAd: InterstitialAd) {
                Log.d(TAG, "Ad was loaded")
                mInterstitialAd = interstitialAd
                mInterstitialAd?.show(this@chatN)
            }

            override fun onAdFailedToLoad(loadAdError: com.google.android.gms.ads.LoadAdError) {
                Log.d(TAG, "Ad failed to load: ${loadAdError.message}")
                mInterstitialAd = null
            }
        })
    }

    override fun onBackPressed() {
        mInterstitialAd?.let {
            it.show(this)
        } ?: super.onBackPressed()
    }
}
