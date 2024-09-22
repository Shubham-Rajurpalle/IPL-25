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
import java.util.Collections

class winners_activity : AppCompatActivity() {

    private var mIntertitialAdd:InterstitialAd?=null
    private final val TAG="venue_activity"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_winners)

        if(Build.VERSION.SDK_INT>= Build.VERSION_CODES.LOLLIPOP){
            val window=window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor= ContextCompat.getColor(this,R.color.status_bar_color)
        }

        MobileAds.initialize(this) { initializationStatus ->
            loadInterstitialAd()
        }

        val back: ImageButton =findViewById(R.id.back)

        back.setOnClickListener {
            var i= Intent(this@winners_activity,MainActivity::class.java)
            startActivity(i)
            finish()
        }

        val recyclerWinnerActivity:RecyclerView=findViewById(R.id.recycle_winners)
        val arrayList=ArrayList<winner_data_item>()
        val i1=winner_data_item(R.drawable.rr,"✦ 2008 ✦","Rajasthan Royals")
        val i2=winner_data_item(R.drawable.dcll,"✦ 2009 ✦","Deccan Chargers")
        val i3=winner_data_item(R.drawable.csk,"✦ 2010 ✦","Chennai Super Kings")
        val i5=winner_data_item(R.drawable.csk,"✦ 2011 ✦","Chennai Super Kings")
        val i6=winner_data_item(R.drawable.kkr,"✦ 2012 ✦","Kolkata Knight Riders")
        val i7=winner_data_item(R.drawable.mi,"✦ 2013 ✦","Mumbai Indians")
        val i8=winner_data_item(R.drawable.kkr,"✦ 2014 ✦","Kolkata Knight Riders")
        val i9=winner_data_item(R.drawable.mi,"✦ 2015 ✦","Mumbai Indians")
        val i10=winner_data_item(R.drawable.sh,"✦ 2016 ✦","Sunrisers Hyderabad")
        val i11=winner_data_item(R.drawable.mi,"✦ 2017 ✦","Mumbai Indians")
        val i12=winner_data_item(R.drawable.csk,"✦ 2018 ✦","Chennai Super Kings")
        val i13=winner_data_item(R.drawable.mi,"✦ 2019 ✦","Mumbai Indians")
        val i14=winner_data_item(R.drawable.mi,"✦ 2020 ✦","Mumbai Indians")
        val i15=winner_data_item(R.drawable.csk,"✦ 2021 ✦","Chennai Super Kings")
        val i16=winner_data_item(R.drawable.gt,"✦ 2022 ✦","Gujarat Titans")
        val i17=winner_data_item(R.drawable.csk,"✦ 2023 ✦","Chennai Super Kings")
        val i18=winner_data_item(R.drawable.kkr,"✦ 2024 ✦","Kolkata Knight Riders")

        arrayList.add(i1)
        arrayList.add(i2)
        arrayList.add(i3)
        arrayList.add(i5)
        arrayList.add(i6)
        arrayList.add(i7)
        arrayList.add(i8)
        arrayList.add(i9)
        arrayList.add(i10)
        arrayList.add(i11)
        arrayList.add(i12)
        arrayList.add(i13)
        arrayList.add(i14)
        arrayList.add(i15)
        arrayList.add(i16)
        arrayList.add(i17)
        arrayList.add(i18)

        Collections.reverse(arrayList)

        val linearLayoutManager=LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerWinnerActivity.layoutManager=linearLayoutManager
        val adapter=myWinnerAdapter(this,arrayList)
        recyclerWinnerActivity.adapter=adapter

    }

    fun loadInterstitialAd(){

        val adRequest=com.google.android.gms.ads.AdRequest.Builder().build()
        InterstitialAd.load(this,"ca-app-pub-1572144131676861/2056204468",adRequest, object : InterstitialAdLoadCallback() {


            override fun onAdLoaded(p0: InterstitialAd) {
                Log.d(TAG, "Ad was loaded")
                mIntertitialAdd=p0
                mIntertitialAdd?.show(this@winners_activity)
            }
        })
    }
}