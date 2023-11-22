package com.eduproject.trafficsafetyeducation.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import com.eduproject.trafficsafetyeducation.R

class SplashActivity : AppCompatActivity() {

    private val SPLASH_TIME_OUT: Long = 2000 // Durasi tampilan Splash dalam milidetik

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        Handler().postDelayed({
            // Fungsi ini akan dijalankan setelah SPLASH_TIME_OUT
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
            finish() // Tutup SplashActivity agar tidak bisa kembali ke halaman ini saat tombol back ditekan
        }, SPLASH_TIME_OUT)
    }
}
// created by Amar Al Fatah & Jhorgi Gheovani Elbet