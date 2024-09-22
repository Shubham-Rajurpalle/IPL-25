package com.cric.ipl25

import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.airbnb.lottie.LottieAnimationView
import com.crick.ipl25.R

class live_score : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_live_score)
        val webView:WebView=findViewById(R.id.webView)
        val bundle:Bundle?=intent.extras
        val back=findViewById<ImageButton>(R.id.back)
        val web=bundle?.getString("key").toString()

        var toast:Toast?=null

        back.setOnClickListener {
            var i= Intent(this@live_score, MainActivity::class.java)
            startActivity(i)
            finish()
        }

        val layout=LayoutInflater.from(this).inflate(R.layout.toast_layout,null)
        val anime=layout.findViewById<LottieAnimationView>(R.id.lottie_loading)
        anime.setAnimation(R.raw.loading_anime)
        anime.playAnimation()
        anime.loop(true)
        toast=Toast(applicationContext)
        toast?.setGravity(Gravity.TOP,0,0)
        toast?.duration=Toast.LENGTH_LONG
        toast?.view=layout
        toast?.show()


        webView.webViewClient=object: WebViewClient(){
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

        webView.settings.javaScriptEnabled=true
        webView.loadUrl(web)
        webView.visibility= View.VISIBLE
    }
}