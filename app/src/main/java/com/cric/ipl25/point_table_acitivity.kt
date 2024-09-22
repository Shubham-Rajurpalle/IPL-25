package com.cric.ipl25

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.airbnb.lottie.LottieAnimationView
import com.crick.ipl25.R
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class point_table_acitivity : AppCompatActivity() {

    private var mIntertitialAdd:InterstitialAd?=null
    private final val TAG="venue_activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_point_table_acitivity)

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP){
            val window=window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor=ContextCompat.getColor(this,R.color.status_bar_color)
        }

        MobileAds.initialize(this) { initializationStatus ->

            loadInterstitialAd()
        }

        val webView:WebView=findViewById(R.id.webView)
        val back:ImageButton=findViewById(R.id.back)

        val bundle:Bundle?=intent.extras
        var web=bundle?.getString("key").toString()

        var toast:Toast?=null

        back.setOnClickListener {
            var i= Intent(this@point_table_acitivity,MainActivity::class.java)
            startActivity(i)
            finish()
        }


        val layoutInflater=LayoutInflater.from(this@point_table_acitivity)
        val layout=layoutInflater.inflate(R.layout.toast_layout,null)
        val anime=layout.findViewById<LottieAnimationView>(R.id.lottie_loading)
        anime.setAnimation(R.raw.loading_anime)
        anime.playAnimation()
        anime.loop(true)
        toast?.setGravity(Gravity.CENTER,0,0)
        toast=Toast(applicationContext)
        toast?.duration=Toast.LENGTH_LONG
        toast?.view=layout
        toast?.show()


        webView.webViewClient= object : WebViewClient(){


            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)

            }

            override fun onPageCommitVisible(view: WebView?, url: String?) {
                super.onPageCommitVisible(view, url)
                toast?.cancel()
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)

            }


        }
        webView.settings.javaScriptEnabled = true
        webView.loadUrl(web)
        webView.visibility = View.VISIBLE



    }

    fun loadInterstitialAd(){

        val adRequest=com.google.android.gms.ads.AdRequest.Builder().build()
        InterstitialAd.load(this,"ca-app-pub-1572144131676861/5915063584",adRequest, object : InterstitialAdLoadCallback() {


            override fun onAdLoaded(p0: InterstitialAd) {
                Log.d(TAG, "Ad was loaded")
                mIntertitialAdd=p0
                mIntertitialAdd?.show(this@point_table_acitivity)
            }
        })
    }


}