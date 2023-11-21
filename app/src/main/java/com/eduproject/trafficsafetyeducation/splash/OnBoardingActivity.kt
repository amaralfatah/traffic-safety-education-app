// OnBoardingActivity.kt
package com.eduproject.trafficsafetyeducation.splash

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager2.widget.ViewPager2
import com.eduproject.trafficsafetyeducation.R
import com.eduproject.trafficsafetyeducation.pretest.PreTestActivity
import me.relex.circleindicator.CircleIndicator3

class OnBoardingActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var lottieFilesList = mutableListOf<String>()
    private lateinit var btnStart : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        window.statusBarColor = Color.WHITE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        postToList()

        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        viewPager2.adapter = ViewPagerAdapter(titlesList, descList, lottieFilesList)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL

        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager2)

        btnStart = findViewById<Button>(R.id.btnStart)
        btnStart.visibility = View.GONE
        btnStart.setOnClickListener {
            val intent = Intent(this, PreTestActivity::class.java)
            startActivity(intent)
            intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK or Intent.FLAG_ACTIVITY_NEW_TASK
            finish()
        }

        viewPager2.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                super.onPageSelected(position)
                if (position == 2) { // 0-indexed
                    btnStart.visibility = View.VISIBLE
                } else {
                    btnStart.visibility = View.GONE
                }
            }
        })

    }

    private fun addToList(title: String, description: String, lottieFile: String) {
        titlesList.add(title)
        descList.add(description)
        lottieFilesList.add(lottieFile)
    }

    private fun postToList() {
        for (i in 1..3) {
            if (i == 1) {
                addToList("Selamat Datang \ndi Traffic Safety Education!", "Mari menjadikan keselamatan berkendara lebih menyenangkan dan siap untuk petualangan belajar yang seru dan informatif!\"", "on_boarding_$i")
            } else if (i == 2) {
                addToList("Tingkatkan Pengetahuanmu!", " Ikuti tes seru, pelajari materi menarik, dan uji kemampuanmu dalam postest!", "on_boarding_$i")
            } else if (i == 3) {
                addToList("Sudah Siap!?", "Ayo, mulai perjalananmu menuju keselamatan berkendara yang keren dan aman!", "on_boarding_$i")
            }
        }
    }
}
