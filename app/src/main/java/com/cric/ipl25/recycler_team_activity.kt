package com.cric.ipl25

import android.content.Intent
import android.graphics.Bitmap
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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

class recycler_team_activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_team)

        var bundle:Bundle?=intent.extras
        var web=bundle?.getString("key").toString()
        var back:ImageButton=findViewById(R.id.back_arrow)

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            val window=window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor= ContextCompat.getColor(this,R.color.status_bar_color)
        }


            var toast:Toast?=null

            val layoutInflater=LayoutInflater.from(this@recycler_team_activity)
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

        back.setOnClickListener {
            var i=Intent(this@recycler_team_activity,MainActivity::class.java)
            startActivity(i)
            finish()
        }




        val webView:WebView=findViewById(R.id.webViewR)
        webView.webViewClient=object :WebViewClient(){

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