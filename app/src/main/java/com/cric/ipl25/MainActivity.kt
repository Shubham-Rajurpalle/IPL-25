package com.cric.ipl25
import android.content.ActivityNotFoundException
import android.content.Intent
import android.net.Uri
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.WindowManager
import android.widget.FrameLayout
import android.widget.GridView
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.airbnb.lottie.LottieAnimationView
import com.cric.ipl25.meme.meme

import com.crick.ipl25.R
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.AdSize
import com.google.android.gms.ads.AdView
import com.google.android.gms.ads.MobileAds
import com.google.android.material.navigation.NavigationView
import com.google.firebase.FirebaseApp
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.database.ValueEventListener
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import retrofit2.Response


class MainActivity : AppCompatActivity() {


    private val baseUrl="https://api.cricapi.com/v1/"
    private lateinit var databaseReference:DatabaseReference


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        CoroutineScope(Dispatchers.Main).launch {
            MobileAds.initialize(this@MainActivity)
        }
        setContentView(R.layout.activity_main)
        loadBannerAd()
        loadBannerAd2()

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val window = window
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
            window.statusBarColor = ContextCompat.getColor(this, R.color.status_bar_color)
        }

        val scoreAtxt:TextView=findViewById(R.id.scoreA)
        val scoreBtxt:TextView=findViewById(R.id.scoreB)
        val drawerLayout:DrawerLayout=findViewById(R.id.drawerLayout)
        val menuButton:ImageButton=findViewById(R.id.menuButton)
        val navigationView:NavigationView=findViewById(R.id.navigationView)
        val teamLogoRecyclerView:RecyclerView=findViewById(R.id.teamLogoRecycle)
        val linearLayoutManager= LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        val dataArray=ArrayList<info_team>()
        val gridView:GridView=findViewById(R.id.gridLayout)
        val dataArrayGrid= ArrayList<button_info>()
        val teamA=findViewById<TextView>(R.id.team1Text)
        val teamB=findViewById<TextView>(R.id.team2text)
        val AImage=findViewById<ImageView>(R.id.teamAlogo)
        val Bimage=findViewById<ImageView>(R.id.teamBlogo)
        val scoreCard=findViewById<CardView>(R.id.scoreCard)
        val directBtn=findViewById<ImageButton>(R.id.directButton)
        val reloadBtn=findViewById<ImageButton>(R.id.reloadButton)
        var toast:Toast?=null
        var fragmentA=findViewById<FrameLayout>(R.id.fragment_container)
        val statusMatch:TextView=findViewById(R.id.overText)
        var ii:Any?=""
        var rateit=findViewById<ImageButton>(R.id.rateit)



        FirebaseApp.initializeApp(this)

        val databaseReference = FirebaseDatabase.getInstance().reference

        menuButton.setOnClickListener(){
            drawerLayout.open()
        }

        var moneyLink:String=""
        var pointTable:String=""
        var predictionLink:String=""
        var liveScoreLink:String=""
        var seeItLink:String=""

        //Link fetching from firebase
        databaseReference.child("link").addListenerForSingleValueEvent(object : ValueEventListener{
            override fun onDataChange(snapshot: DataSnapshot) {
                moneyLink= snapshot.child("moneyLink").getValue(String::class.java).toString()
                seeItLink=snapshot.child("seeItLink").getValue(String::class.java).toString()
                predictionLink=snapshot.child("predictionLink").getValue(String::class.java).toString()
                liveScoreLink=snapshot.child("liveScoreLink").getValue(String::class.java).toString()
                pointTable= snapshot.child("pointTable").getValue(String::class.java).toString()

            }
            override fun onCancelled(error: DatabaseError) {
            }

        })



        rateit.setOnClickListener(View.OnClickListener {
            try {
                val rateIntent = Intent(Intent.ACTION_VIEW)
                rateIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName))
                rateIntent.setPackage("com.android.vending")
                startActivity(rateIntent)
            }
            catch (e: ActivityNotFoundException) {
                val rateIntent = Intent(Intent.ACTION_VIEW)
                rateIntent.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + packageName))
                startActivity(rateIntent)
            }
        })

        navigationView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item clicks here
            when (menuItem.itemId) {
                R.id.privacyP -> {
                    val i = Intent(Intent.ACTION_VIEW, Uri.parse("https://sites.google.com/view/ipl-25-privacy-policy/home"))
                    startActivity(i)
                }

                R.id.rateApp -> {
                    try {
                        val rateIntent = Intent(Intent.ACTION_VIEW)
                        rateIntent.data = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)
                        rateIntent.setPackage("com.android.vending")
                        startActivity(rateIntent)
                    } catch (e: ActivityNotFoundException) {
                        val rateIntent = Intent(Intent.ACTION_VIEW)
                        rateIntent.data = Uri.parse("https://play.google.com/store/apps/details?id=" + packageName)
                        startActivity(rateIntent)
                    }
                }

                R.id.shareApp -> {
                    val i = Intent(Intent.ACTION_SEND)
                    i.type = "text/plain"
                    i.putExtra(Intent.EXTRA_SUBJECT, "Share App")
                    i.putExtra(Intent.EXTRA_TEXT, "Best App To Stay Updated For IPL 2025 \n\n" +
                            "https://play.google.com/store/apps/details?id=" + packageName)
                    startActivity(Intent.createChooser(i, "Share App Via..."))
                }
            }
            drawerLayout.closeDrawer(GravityCompat.START)
            true
        }




        teamLogoRecyclerView.layoutManager=linearLayoutManager

        val i1=info_team(R.drawable.csk)
        val i2=info_team(R.drawable.rcb)
        val i3=info_team(R.drawable.mi)
        val i4=info_team(R.drawable.gt)
        val i5=info_team(R.drawable.kkr)
        val i6=info_team(R.drawable.rr)
        val i7= info_team(R.drawable.pk)
        val i8=info_team(R.drawable.dc)
        val i9=info_team(R.drawable.lsg)
        val i10=info_team(R.drawable.sh)

        dataArray.add(i1)
        dataArray.add(i2)
        dataArray.add(i3)
        dataArray.add(i4)
        dataArray.add(i5)
        dataArray.add(i6)
        dataArray.add(i7)
        dataArray.add(i8)
        dataArray.add(i9)
        dataArray.add(i10)

        val myAdapter =myAdapter(this,dataArray)
        teamLogoRecyclerView.adapter=myAdapter

        val a1=button_info(R.drawable.meme_b,"Memes")
        val a2= button_info(R.drawable.quiz_b,"Quiz")
        val a3=button_info(R.drawable.community_b,"Chat")
        val a4=button_info(R.drawable.prediction_b,"Predict..")
        val a5=button_info(R.drawable.pointtable_b,"Points..")
        val a6=button_info(R.drawable.venue_b,"Venue")
        val a7=button_info(R.drawable.imp_b,"See it!")
        val a8=button_info(R.drawable.winners_b,"Winners")
        val a9=button_info(R.drawable.money_b,"Money")



        dataArrayGrid.add(a1)
        dataArrayGrid.add(a2)
        dataArrayGrid.add(a3)
        dataArrayGrid.add(a4)
        dataArrayGrid.add(a5)
        dataArrayGrid.add(a6)
        dataArrayGrid.add(a7)
        dataArrayGrid.add(a8)
        dataArrayGrid.add(a9)




        val customGridAdapter=customGridAdapter(this,dataArrayGrid)

        gridView.adapter=customGridAdapter

        gridView.setOnItemClickListener { adapterView, view, position, l ->


           when(position){

               0->{
                   val i=Intent(this, meme::class.java)
                   startActivity(i)
               }

               1->{
                   val i=Intent(this,quiz::class.java)
                   startActivity(i)
               }

               2->{
                   supportFragmentManager.beginTransaction()
                       .replace(R.id.fragment_container, TeamSelectionFragment())
                       .addToBackStack(null)
                       .commit()
               }

               4->{
                   val i= Intent(this,point_table_acitivity::class.java)
                   i.putExtra("key",pointTable)
                   startActivity(i)
               }

               3->{
                   val i= Intent(this,point_table_acitivity::class.java)
                   i.putExtra("key",predictionLink)
                   startActivity(i)
               }

               6->{
                   val i=Intent(this,point_table_acitivity::class.java)
                   i.putExtra("key",seeItLink)
                   startActivity(i)
               }

               5->{
                   val i=Intent(this,venue_activity::class.java)
                   startActivity(i)
               }

               7->{
                   val i=Intent(this,winners_activity::class.java)
                   startActivity(i)
               }

               8->{
                   val i=Intent(this,point_table_acitivity::class.java)
                   i.putExtra("key",moneyLink)
                   startActivity(i)
               }
           }


        }


        // Api integration

        //https://api.cricapi.com/v1/series_info?apikey=656cfa71-1ad3-4a35-b41c-6da66a4a5b9b&offset=0&id=76ae85e2-88e5-4e99-83e4-5f352108aebc
        //api key-656cfa71-1ad3-4a35-b41c-6da66a4a5b9b

        fun forCurrentMatch(i:Data){

            val titleA = i.teamInfo[0].shortname
            val titleB = i.teamInfo[1].shortname
            teamA.text=titleA
            teamB.text=titleB
            scoreAtxt.text=""
            scoreBtxt.text=""
            if (i.matchStarted==false){
                statusMatch.text=i.status
            }

            if(i.score!=null) {

                if (i.score[0].inning.equals(i.teams[1] + " Inning 1")) {

                    val runA = i.score[0].r.toString()
                    val wicA = i.score[0].w.toString()

                    val ascore = runA + "/" + wicA
                    scoreAtxt.text = ascore

                    statusMatch.text = i.score[0].o.toString() + " overs"

                } else {
                    val runB = i.score[0].r.toString()
                    val wicB = i.score[0].w.toString()

                    val bscore = runB + "/" + wicB
                    scoreBtxt.text = bscore

                    statusMatch.text = i.score[0].o.toString() + " overs"

                }

                if (i.score[1].inning.equals(i.teams[1] + " Inning 1")) {

                    val runA = i.score[1].r.toString()
                    val wicA = i.score[1].w.toString()

                    val ascore = runA + "/" + wicA
                    scoreAtxt.text = ascore

                    statusMatch.text = i.score[1].o.toString() + " overs"

                } else {
                    val runB = i.score[1].r.toString()
                    val wicB = i.score[1].w.toString()

                    val bscore = runB + "/" + wicB
                    scoreBtxt.text = bscore

                    statusMatch.text = i.score[1].o.toString() + " overs"

                }
            }

            if (i.matchEnded==true){
                statusMatch.text=i.status
            }





            if (titleA.equals("DC")) {
                AImage.setImageResource(R.drawable.dc)
            } else if (titleA.equals("KKR")) {
                AImage.setImageResource(R.drawable.kkr)
            } else if (titleA.equals("RCB")) {
                AImage.setImageResource(R.drawable.rcb)
            } else if (titleA.equals("CSK")) {
                AImage.setImageResource(R.drawable.csk)
            } else if (titleA.equals("MI")) {
                AImage.setImageResource(R.drawable.mi)
            } else if (titleA.equals("RR")) {
                AImage.setImageResource(R.drawable.rr)
            } else if (titleA.equals("LSG")) {
                AImage.setImageResource(R.drawable.lsg)
            } else if (titleA.equals("PBKS")) {
                AImage.setImageResource(R.drawable.pk)
            } else if (titleA.equals("SRH")) {
                AImage.setImageResource(R.drawable.sh)
            } else {
                AImage.setImageResource(R.drawable.gt)
            }

            if (titleB.equals("DC")) {
                Bimage.setImageResource(R.drawable.dc)
            } else if (titleB.equals("MI")) {
                Bimage.setImageResource(R.drawable.mi)
            } else if (titleB.equals("CSK")) {
                Bimage.setImageResource(R.drawable.csk)
            } else if (titleB.equals("SRH")) {
                Bimage.setImageResource(R.drawable.sh)
            } else if (titleB.equals("RR")) {
                Bimage.setImageResource(R.drawable.rr)
            } else if (titleB.equals("LSG")) {
                Bimage.setImageResource(R.drawable.lsg)
            } else if (titleB.equals("GT")) {
                Bimage.setImageResource(R.drawable.gt)
            } else if (titleB.equals("KKR")) {
                Bimage.setImageResource(R.drawable.kkr)
            } else if (titleB.equals("RCB")) {
                Bimage.setImageResource(R.drawable.rcb)
            } else {
                Bimage.setImageResource(R.drawable.pk)
            }

        }

        val postReference = object : ValueEventListener {
            override fun onDataChange(dataSnapshot: DataSnapshot) {
                if (dataSnapshot.exists()) {
                    val link = dataSnapshot.value
                    ii = link
                    val responseLiveData:LiveData<Response<data_to_show_ipl>> =
                        liveData {
                            val response=retrofitInstance(baseUrl).getData(ii)
                            emit(response)

                        }

                    responseLiveData.observe(this@MainActivity, {
                        val dataObj = it.body()?.data
                        if (dataObj != null) {
                            forCurrentMatch(dataObj)
                        }
                    })

                }
            }

            override fun onCancelled(databaseError: DatabaseError) {

            }
        }
        databaseReference.child("id").addValueEventListener(postReference)

        reloadBtn.setOnClickListener {

            val postReference = object : ValueEventListener {
                override fun onDataChange(dataSnapshot: DataSnapshot) {
                    if (dataSnapshot.exists()) {
                        val link = dataSnapshot.value
                        ii = link
                        val responseLiveData:LiveData<Response<data_to_show_ipl>> =
                            liveData {
                                val response=retrofitInstance(baseUrl).getData(ii)
                                emit(response)

                            }

                        responseLiveData.observe(this@MainActivity, {
                            val dataObj = it.body()?.data
                            if (dataObj != null) {

                                forCurrentMatch(dataObj)

                            }else{
                                if (it.body()?.status=="failure"){
                                    Toast.makeText(this@MainActivity,"Server Not Available",Toast.LENGTH_SHORT).show()
                                    val i=Intent(this@MainActivity,live_score::class.java)
                                    i.putExtra("key",liveScoreLink)
                                    startActivity(i)
                                }
                            }
                        })

                    }
                }

                override fun onCancelled(databaseError: DatabaseError) {

                }
            }
            databaseReference.child("id").addValueEventListener(postReference)

            val layout=LayoutInflater.from(this@MainActivity).inflate(R.layout.toast_load_ring,null)
            val anime=layout.findViewById<LottieAnimationView>(R.id.lottie_loading_ring)
            anime.setAnimation(R.raw.load_line)
            anime.playAnimation()
            anime.loop(true)
            toast=Toast(applicationContext)
            toast?.duration=Toast.LENGTH_LONG
            toast?.setGravity(Gravity.TOP,0,0)
            toast?.view=layout
            toast?.show()

        }

        directBtn.setOnClickListener {
            var i=Intent(this@MainActivity,live_score::class.java)
                i.putExtra("key",liveScoreLink)
                startActivity(i)
        }



    }

    private fun loadBannerAd() {
        val adView = AdView(this)
        adView.setAdSize(AdSize.MEDIUM_RECTANGLE)
        adView.adUnitId = "ca-app-pub-1572144131676861/7947891057"
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)

        /*adView.adListener = object: AdListener() {

            override fun onAdFailedToLoad(adError : LoadAdError) {
                super.onAdFailedToLoad(adError)
                adView.loadAd(adRequest)
            }
        }*/
        val adContainer = findViewById<FrameLayout>(R.id.ad_container)
        adContainer.addView(adView)
    }

    private fun loadBannerAd2() {
        val adView = AdView(this)
        adView.setAdSize(AdSize.BANNER)
        adView.adUnitId = "ca-app-pub-1572144131676861/6453237755"
        val adRequest = AdRequest.Builder().build()
        adView.loadAd(adRequest)
        val adContainer = findViewById<FrameLayout>(R.id.ad_container2)
        adContainer.addView(adView)
    }
}

