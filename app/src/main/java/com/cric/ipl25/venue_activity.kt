package com.cric.ipl25

import android.content.Intent
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.ImageButton
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.crick.ipl25.R
import com.google.android.gms.ads.MobileAds
import com.google.android.gms.ads.interstitial.InterstitialAd
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback

class venue_activity : AppCompatActivity() {

    private var mIntertitialAdd:InterstitialAd?=null
    private final val TAG="venue_activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_venue)

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            val window=window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor= ContextCompat.getColor(this,R.color.status_bar_color)
        }

        MobileAds.initialize(this) { initializationStatus ->

            loadInterstitialAd()
        }


        val back:ImageButton=findViewById(R.id.back)

        back.setOnClickListener {
            var i= Intent(this@venue_activity,MainActivity::class.java)
            startActivity(i)
            finish()
        }

        val recyclerVenue:RecyclerView=findViewById(R.id.recycle_venue)
        val llm=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        val venueList=ArrayList<venue_data>()
        val a1=venue_data(R.drawable.eg,"Eden Gardens,Kolkata")
        val a2=venue_data(R.drawable.mcs,"M.Chinnaswamy Stadium,Bengaluru")
        val a3=venue_data(R.drawable.mac,"MA Chidambaram Stadium,Chennai")
        val a4=venue_data(R.drawable.isbp,"I.S. Bindra Punjab Stadium,Mohali")
        val a5=venue_data(R.drawable.nms,"Narendra Modi Stadium, Ahmedabad")
        val a6=venue_data(R.drawable.sms,"Sawai Mansingh Stadium, Jaipur")
        val a7=venue_data(R.drawable.rgis,"Rajiv Gandhi Stadium,Hyderabad")
        val a8=venue_data(R.drawable.ws,"Wankhede Stadium, Mumbai")
        val a9=venue_data(R.drawable.drars,"Dr.Y.S.Rajasekhara ,Visakhapatnam")
        val a10=venue_data(R.drawable.abv,"Shri Atal Bihari Vajpayee,Lucknow")
        val a11=venue_data(R.drawable.hvpa,"HPCA Stadium,Dharamsala")
        val a12=venue_data(R.drawable.ajs,"Arun Jaitley Stadium,New Delhi")

        venueList.add(a1)
        venueList.add(a2)
        venueList.add(a3)
        venueList.add(a4)
        venueList.add(a5)
        venueList.add(a6)
        venueList.add(a7)
        venueList.add(a8)
        venueList.add(a9)
        venueList.add(a10)
        venueList.add(a11)
        venueList.add(a12)

        val venueAdapter=venueAdapter(this,venueList)
        recyclerVenue.layoutManager=llm
        recyclerVenue.adapter=venueAdapter

    }

    fun loadInterstitialAd(){

        val adRequest=com.google.android.gms.ads.AdRequest.Builder().build()
        InterstitialAd.load(this,"ca-app-pub-1572144131676861/2486136222",adRequest, object : InterstitialAdLoadCallback() {


            override fun onAdLoaded(p0: InterstitialAd) {
                Log.d(TAG, "Ad was loaded")
                mIntertitialAdd=p0
                mIntertitialAdd?.show(this@venue_activity)
            }
        })
    }
}