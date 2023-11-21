package com.eduproject.trafficsafetyeducation.materi

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.animation.ObjectAnimator
import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Intent
import android.content.res.ColorStateList
import android.graphics.Color
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
import com.eduproject.trafficsafetyeducation.posttest.PosttestActivity
import com.google.android.exoplayer2.ExoPlayer
import com.google.android.exoplayer2.MediaItem
import com.google.android.exoplayer2.Player
import com.google.android.exoplayer2.source.ProgressiveMediaSource
import com.google.android.exoplayer2.upstream.DataSource
import com.google.android.exoplayer2.upstream.DataSpec
import com.google.android.exoplayer2.upstream.RawResourceDataSource

class SecondVideoActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondVideoBinding
    private lateinit var btnToSecond: Button
    private var isVideoFinished = false // Penanda jika video telah selesai

    private var exoPlayer: ExoPlayer? = null
    private var playbackPosition = 0L
    private var playWhenReady = true

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondVideoBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        preparePlayer()

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
                    val intent = Intent(this@SecondVideoActivity, PosttestActivity::class.java)
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

    private fun preparePlayer() {
        exoPlayer = ExoPlayer.Builder(this).build()
        exoPlayer?.playWhenReady = playWhenReady
        exoPlayer?.addListener(object : Player.Listener {
            override fun onPlaybackStateChanged(state: Int) {
                super.onPlaybackStateChanged(state)
                when (state) {
                    Player.STATE_READY -> {
                        // Video ready to play, you can enable the button here
                        btnToSecond.isEnabled = false
                    }
                    Player.STATE_ENDED -> {
                        // Video playback ended, you can enable the button here
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
        })

        binding.playerView.player = exoPlayer

        val uri = RawResourceDataSource.buildRawResourceUri(R.raw.materi_first)
        val dataSpec = DataSpec(uri)
        val rawResourceDataSource = RawResourceDataSource(this)

        try {
            rawResourceDataSource.open(dataSpec)
            val factory = DataSource.Factory { rawResourceDataSource }
            val mediaSource = ProgressiveMediaSource.Factory(factory).createMediaSource(MediaItem.fromUri(uri))
            exoPlayer?.setMediaSource(mediaSource)
            exoPlayer?.prepare()
        } catch (e: RawResourceDataSource.RawResourceDataSourceException) {
            e.printStackTrace()
        }
    }

    private fun relasePlayer() {
        exoPlayer?.release()
        exoPlayer = null
    }

    override fun onStop() {
        super.onStop()
        relasePlayer()
    }

    override fun onPause() {
        super.onPause()
        relasePlayer()
    }

    override fun onDestroy() {
        super.onDestroy()
        relasePlayer()
    }

    override fun onBackPressed() {
        AlertDialog.Builder(this)
            .setTitle("Konfirmasi")
            .setMessage("Apakah kamu yakin ingin keluar?")
            .setPositiveButton("Ya") { _, _ ->
                // Jika "Ya" ditekan, keluar dari semua activity
                finishAffinity()
            }
            .setNegativeButton("Tidak", null)
            .show()
            .getButton(AlertDialog.BUTTON_POSITIVE).setTextColor(Color.RED)
    }
}
