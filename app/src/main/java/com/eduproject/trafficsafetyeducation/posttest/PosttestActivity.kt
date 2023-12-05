package com.eduproject.trafficsafetyeducation.posttest

import android.app.AlertDialog
import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eduproject.trafficsafetyeducation.Constanta
import com.eduproject.trafficsafetyeducation.R
import com.eduproject.trafficsafetyeducation.adapter.MultipleChoiceAdapter
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.databinding.ActivityPosttestBinding
import com.eduproject.trafficsafetyeducation.databinding.CustomViewLayoutBinding
import com.eduproject.trafficsafetyeducation.finalresult.FinalResultActivity
import com.eduproject.trafficsafetyeducation.finalresult.FinalResultViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class PosttestActivity : AppCompatActivity() {

    private val postTestViewModel: PostTestViewModel by viewModel()
    private val finalResultViewModel: FinalResultViewModel by viewModel()
    private lateinit var binding: ActivityPosttestBinding
    private lateinit var customView: CustomViewLayoutBinding

    private var correctAnswerCount: Int = 0 //use for count the correct answer
    private var currentIndex = 0 // use to track the currect index
    private var correctAnswer: String = "" // use to track the current answer
    private var isAnswered: Boolean = false //use to track if question has been answer or not
    private var isCorrect: Boolean = false // use to track if the answer was correct
    private val userAnswers = mutableMapOf<Int, String>() // use to store the user answer
    private val answeredCorrectly = mutableMapOf<Int, Boolean>() //use to store isAnswered

    // countdown timer
    private lateinit var timerTextView: TextView
    private lateinit var countDownTimer: CountDownTimer

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPosttestBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupRecyclerView()
        postTestViewModel.postest()

        postTestViewModel.postest.observe(this) { data ->
            updateQuestion(data)

            binding.nextButton.setOnClickListener {
                navigateToNextQuestion(data)
            }

            binding.prevButton.setOnClickListener {
                navigateToPreviousQuestion(data)
            }
        }

        // countdown timer
        timerTextView = binding.tvTimer
        startTimer()

    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMultipleChoice.layoutManager = layoutManager
    }

    private fun updateQuestion(data: List<Postest>) {
        val currentItem = data[currentIndex]
        binding.pertanyaan.text = currentItem.question
        binding.soalNomor.text = "${currentIndex + 1}"
        correctAnswer = currentItem.correctAnswer
        isAnswered = userAnswers.containsKey(currentIndex)
        isCorrect = answeredCorrectly[currentIndex] ?: false
        if (!userAnswers.containsKey(currentIndex)) {
            answeredCorrectly[currentIndex] = false
        }
//        binding.clickedAnswer.text = currentItem.correctAnswer
        updateImage(currentItem.images)



        val currentAnswer = userAnswers[currentIndex]?:""
        val multipleChoiceAdapter = binding.rvMultipleChoice.adapter as? MultipleChoiceAdapter
        if (multipleChoiceAdapter != null) {
            multipleChoiceAdapter.updateData(currentItem.answer, currentIndex, currentAnswer)
        } else {
            val newAdapter = MultipleChoiceAdapter(currentItem.answer, currentAnswer, currentIndex, Constanta.POSTEST_ARG, this) { clickAnswer ->
                handleAnswerClick(clickAnswer)
            }
            binding.rvMultipleChoice.adapter = newAdapter
        }

        val isFirstQuestion = currentIndex == 0
        val isLastQuestion = currentIndex == data.size - 1

        binding.prevButton.visibility = if (isFirstQuestion) View.INVISIBLE else View.VISIBLE
        binding.nextButton.visibility = if (isLastQuestion) View.INVISIBLE else View.VISIBLE
    }

    private fun updateImage(imageName: String) {
        val resID = resources.getIdentifier(imageName, "drawable", packageName)
        if (resID != 0) {
            binding.IVSoal.visibility = View.VISIBLE
            binding.IVSoal.setImageResource(resID)
        } else {
            binding.IVSoal.visibility = View.GONE
        }
    }

    private fun handleAnswerClick(clickAnswer: String) {
        val previousAnswer = userAnswers[currentIndex]

        if (previousAnswer != null) { // User has answered this question before
            if (previousAnswer == correctAnswer) { // Previous answer was correct
                if (clickAnswer != correctAnswer) {
                    // User changed the answer from correct to incorrect
                    correctAnswerCount = maxOf(correctAnswerCount - 1, 0)
                }
            } else { // Previous answer was incorrect
                if (clickAnswer == correctAnswer) {
                    // User changed the answer from incorrect to correct
                    correctAnswerCount++
                }
            }
        } else { // User is answering this question for the first time
            if (clickAnswer == correctAnswer) {
                // User answered the question correctly
                correctAnswerCount++
            }
//            else {
//                // User answered the question incorrectly
//                correctAnswerCount = maxOf(correctAnswerCount - 1, 0)
//            }
        }

        userAnswers[currentIndex] = clickAnswer
//        binding.counter.text = "skor $correctAnswerCount"
    }

    private fun navigateToNextQuestion(data: List<Postest>) {
        if (currentIndex < data.size - 1) {
            currentIndex++
            updateQuestion(data)
        }
    }

    private fun navigateToPreviousQuestion(data: List<Postest>) {
        if (currentIndex > 0) {
            currentIndex--
            updateQuestion(data)
        }
    }

    fun customDialog() {
        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .create()
        customView = CustomViewLayoutBinding.inflate(layoutInflater)
        builder.setView(customView.root)

        customView.score.text = correctAnswerCount.toString()
        customView.dialogDismissButton.setOnClickListener {
            finalResultViewModel.savePostestScore(correctAnswerCount, this)
            val intent = Intent(this, FinalResultActivity::class.java)
            startActivity(intent)
            finish()
            builder.dismiss()
        }

        builder.setCanceledOnTouchOutside(false)
        builder.show()
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

    private fun startTimer() {
        countDownTimer = object : CountDownTimer(1800000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val minutes = millisUntilFinished / 1000 / 60
                val seconds = millisUntilFinished / 1000 % 60
                timerTextView.text = String.format("%02d:%02d", minutes, seconds)
            }
            override fun onFinish() {
                timerTextView.text = "00:00"
                showRestartDialog()
            }
        }

        countDownTimer.start()
    }

    private fun showRestartDialog() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Waktu Habis")
        builder.setMessage("Apakah kamu ingin memulai lagi?")
        builder.setPositiveButton("Mulai Lagi") { _, _ ->
            timerTextView.text = "30:00"
            currentIndex = 0
            correctAnswerCount = 0
            userAnswers.clear()
            answeredCorrectly.clear()
            postTestViewModel.postest.value?.let { updateQuestion(it) }
            startTimer()
        }
        builder.setCancelable(false)
        val dialog = builder.create()
        dialog.show()
    }
}
