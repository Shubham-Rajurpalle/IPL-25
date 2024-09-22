package com.cric.ipl25

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.WindowManager.LayoutParams
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.crick.ipl25.R

class Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_splash)

       window.setFlags(
           LayoutParams.FLAG_LAYOUT_NO_LIMITS,
           LayoutParams.FLAG_LAYOUT_NO_LIMITS
       )

        Handler(Looper.getMainLooper()).postDelayed({
            var i= Intent(this@Splash,MainActivity::class.java)
            startActivity(i)
            finish()
        },3000)
    }
}