package com.eduproject.trafficsafetyeducation.materi

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.content.Intent
import android.content.res.ColorStateList
import android.os.Bundle
import android.os.Handler
import android.util.DisplayMetrics
import android.view.LayoutInflater
import android.view.View
import android.webkit.WebSettings
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.content.ContextCompat
import androidx.core.widget.NestedScrollView
import com.airbnb.lottie.LottieAnimationView
import com.eduproject.trafficsafetyeducation.R
import com.eduproject.trafficsafetyeducation.databinding.ActivitySecondVideoBinding

class SecondVideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondVideoBinding
    private lateinit var btnToSecond: Button
    private var isVideoFinished = false // Penanda jika video telah selesai

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondVideoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        val webView: WebView = binding.webView
//        val video = "<iframe id=\"youtubePlayer\" width=\"100%\" height=\"100%\" src=\"https://www.youtube.com/embed/cMzmC6vuM-k?si=yEVZ6xZjvMxZANTt\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
//        val video = "<iframe id=\"youtubePlayer\" width=\"100%\" src=\"https://www.youtube.com/embed/pPleo8f4fj8?si=KH-LYOOkL20mTEFl\" title=\"YouTube video player\" frameborder=\"0\" allow=\"accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture; web-share\" allowfullscreen></iframe>"
//        webView.loadData(video, "text/html", "utf-8")
        val video = """
                        <div id="player"></div>
                        <script>
                            var player;
                            function onYouTubeIframeAPIReady() {
                                player = new YT.Player('player', {
                                    height: '100%',
                                    width: '100%',
                                    videoId: 'XjKkc_xS07s',
                                    events: {
                                        'onStateChange': onPlayerStateChange
                                    }
                                });
                            }
                    
                            function onPlayerStateChange(event) {
                                if (event.data == YT.PlayerState.ENDED) {
                                    Android.videoFinished();
                                }
                            }
                        </script>
                        <script src="https://www.youtube.com/iframe_api"></script>
                    """
        webView.loadDataWithBaseURL("https://www.youtube.com", video, "text/html", "utf-8", null)
        val webSettings: WebSettings = webView.settings
        webSettings.javaScriptEnabled = true
        webView.webViewClient = WebViewClient()
        webView.webChromeClient = CustomWebChromeClient(this)

        // Aktifkan tombol setelah video selesai
        webView.addJavascriptInterface(JavaScriptInterface(), "Android")
        val javascript = """
                            var youtubePlayer = document.getElementById('youtubePlayer');
                            
                            function checkVideoStatus() {
                                if (youtubePlayer && youtubePlayer.getCurrentTime() >= youtubePlayer.getDuration()) {
                                    Android.videoFinished();
                                }
                            }
                
                            setInterval(checkVideoStatus, 1000);
                        """
        webView.evaluateJavascript(javascript, null)

        // Ambil materi
        val containerMateri: LinearLayout = findViewById(R.id.containerMateri)
        populateContainerMateri(containerMateri)

        // Button
        btnToSecond = findViewById<AppCompatButton>(R.id.button)
        btnToSecond.text = "Kamu belum menonton"
        btnToSecond.setAllCaps(false)
        btnToSecond.isEnabled = false
        val color = ContextCompat.getColor(this@SecondVideoActivity, R.color.main_blue)
        btnToSecond.backgroundTintList = ColorStateList.valueOf(color)
        val textColor = ContextCompat.getColor(this@SecondVideoActivity, R.color.white)
        btnToSecond.setTextColor(textColor)

        // Lottie
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottieAnimationView)
        lottieAnimationView.setOnClickListener {
            // Event ketika LottieAnimationView ditekan
            lottieAnimationView.playAnimation()
        }
        btnToSecond.setOnClickListener {
            if (isVideoFinished) {
                lottieAnimationView.visibility = View.VISIBLE
                fadeInAnimation(lottieAnimationView)
                lottieAnimationView.playAnimation()

                // Menjadwalkan penghilangan animasi setelah 1 detik
                Handler().postDelayed({
                    val intent = Intent(this@SecondVideoActivity, FirstVideoActivity::class.java)
                    startActivity(intent)
                    fadeOutAnimation(lottieAnimationView)
                    lottieAnimationView.cancelAnimation()
                    lottieAnimationView.visibility = View.GONE // Sembunyikan animasi
                }, 3000) // Waktu penundaan dalam milidetik (di sini, 2000 ms atau 2 detik)

                // Mengubah properti tombol setelah diklik
                btnToSecond.isEnabled = false

                // Menjadwalkan pengembalian properti tombol setelah sejumlah waktu tertentu
                Handler().postDelayed({
                    btnToSecond.isEnabled = true
                }, 3000) // Misalnya, setelah 3 detik, tombol akan aktif kembali
            }
        }
        centerLottieAnimationViewInScrollView()
    }

    inner class JavaScriptInterface {
        @android.webkit.JavascriptInterface
        fun videoFinished() {
            runOnUiThread {
                isVideoFinished = true // Set marker bahwa video telah selesai
                btnToSecond.isEnabled = true

                val color = ContextCompat.getColor(this@SecondVideoActivity, R.color.white)
                btnToSecond.backgroundTintList = ColorStateList.valueOf(color)
                val textColor = ContextCompat.getColor(this@SecondVideoActivity, R.color.main_blue)
                btnToSecond.setTextColor(textColor)

                btnToSecond.text = "Kamu sudah menonton"
            }
        }
    }

    @SuppressLint("InflateParams")
    private fun populateContainerMateri(containerMateri: LinearLayout) {
        val images = resources.obtainTypedArray(R.array.images_nd)
        val subtitles = resources.getStringArray(R.array.sub_titles_nd)
        val descriptions = resources.getStringArray(R.array.descriptions_nd)

        for (i in subtitles.indices) {
            val inflater = getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater
            val itemData = inflater.inflate(R.layout.item_data, null)

            val imageView: ImageView = itemData.findViewById(R.id.imageView)
            val subTitle: TextView = itemData.findViewById(R.id.subTitle)
            val desc: TextView = itemData.findViewById(R.id.desc)

            imageView.setImageResource(images.getResourceId(i, -1))
            subTitle.text = subtitles[i]
            desc.text = descriptions[i]

            containerMateri.addView(itemData)
        }
        images.recycle()
    }

    private fun centerLottieAnimationViewInScrollView() {
        val lottieAnimationView = findViewById<LottieAnimationView>(R.id.lottieAnimationView)
        val nestedScrollView = findViewById<NestedScrollView>(R.id.nestedScrollView)

        val displayMetrics = DisplayMetrics()
        windowManager.defaultDisplay.getMetrics(displayMetrics)
        val screenHeight = displayMetrics.heightPixels

        nestedScrollView.viewTreeObserver.addOnGlobalLayoutListener {
            val contentViewHeight = nestedScrollView.getChildAt(0).height
            val marginVertical = (screenHeight - contentViewHeight) / 2

            val params = lottieAnimationView.layoutParams as ConstraintLayout.LayoutParams
            params.topMargin = marginVertical
            params.bottomMargin = marginVertical
            lottieAnimationView.layoutParams = params
        }
    }

    private fun fadeInAnimation(view: View) {
        val animation = ObjectAnimator.ofFloat(view, "alpha", 0f, 1f)
        animation.duration = 1000 // Durasi animasi dalam milidetik
        animation.start()
    }

    private fun fadeOutAnimation(view: View) {
        val fadeOut = ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        fadeOut.duration = 1000 // Durasi animasi dalam milidetik
        fadeOut.start()
        fadeOut.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                view.visibility = View.GONE
            }
        })
    }
}
