package com.eduproject.trafficsafetyeducation.splash

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.eduproject.trafficsafetyeducation.R
import me.relex.circleindicator.CircleIndicator3

class OnBoardingActivity : AppCompatActivity() {

    private var titlesList = mutableListOf<String>()
    private var descList = mutableListOf<String>()
    private var lottieFilesList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_on_boarding)
        window.statusBarColor = Color.WHITE
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR

        postToList()

        // Menginisialisasi ViewPager2
        val viewPager2 = findViewById<ViewPager2>(R.id.view_pager2)
        viewPager2.adapter = ViewPagerAdapter(titlesList,descList,lottieFilesList)
        viewPager2.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        val indicator = findViewById<CircleIndicator3>(R.id.indicator)
        indicator.setViewPager(viewPager2)

    }

    private fun addToList(title: String, description: String, lottieFile: String) {
        titlesList.add(title)
        descList.add(description)
        lottieFilesList.add(lottieFile)
    }

    private fun postToList() {
        for (i in 1..3) {
            if (i == 1) {
                addToList("Selamat Datang \ndi Traffic Safety Education!", "Tempat di mana keamanan di jalan raya jadi asyik. Bersiaplah untuk memulai petualangan belajar yang penuh keseruan dan pengetahuan!", "on_boarding_$i")
            } else if (i == 2) {
                addToList("Lengkapin Pengetahuan Kamu!", "Yuk, mulai dengan tes awal yang seru, pelajari materi-materi menarik, dan ujilah kemampuanmu dalam postest!", "on_boarding_$i")
            } else if (i == 3) {
                addToList("ARE YOU READY!?", "Langsung masuk dan jelajahi segala fitur seru yang ada di Traffic Safety Education. Yuk, mulai perjalananmu menuju keselamatan berkendara yang keren dan aman!", "on_boarding_$i")
            }

        }
    }
}
