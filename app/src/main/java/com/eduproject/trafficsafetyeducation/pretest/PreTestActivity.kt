package com.eduproject.trafficsafetyeducation.pretest

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eduproject.trafficsafetyeducation.Constanta
import com.eduproject.trafficsafetyeducation.R
import com.eduproject.trafficsafetyeducation.adapter.MultipleChoiceAdapter
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.databinding.ActivityPreTestBinding
import com.eduproject.trafficsafetyeducation.databinding.CustomViewLayoutBinding
import com.eduproject.trafficsafetyeducation.finalresult.FinalResultViewModel
import com.eduproject.trafficsafetyeducation.materi.FirstVideoActivity
import com.eduproject.trafficsafetyeducation.posttest.PosttestActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class PreTestActivity : AppCompatActivity() {

    private val pretestViewModel: PretestViewModel by viewModel()
    private val finalResultViewModel: FinalResultViewModel by viewModel()
    private lateinit var binding: ActivityPreTestBinding
    private lateinit var customView: CustomViewLayoutBinding
    private var correctAnswerCount: Int = 0
    private var currentIndex = 0
    private var correctAnswer: String = ""
    private var isAnswered: Boolean = false
    private var isCorrect: Boolean = false
    private val userAnswers = mutableMapOf<Int, String>()
    private val answeredCorrectly = mutableMapOf<Int, Boolean>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPreTestBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setupRecyclerView()
        pretestViewModel.pretest()

        pretestViewModel.pretest.observe(this) { data ->
            updateQuestion(data)

            binding.nextButton.setOnClickListener {
                navigateToNextQuestion(data)
            }

            binding.prevButton.setOnClickListener {
                navigateToPreviousQuestion(data)
            }
        }


    }

    private fun setupRecyclerView() {
        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMultipleChoice.layoutManager = layoutManager
    }

    private fun updateQuestion(data: List<DataEntity>) {
        val currentItem = data[currentIndex]
        binding.pertanyaan.text = currentItem.question
        binding.soalNomor.text = "${currentIndex + 1}"
        correctAnswer = currentItem.correctAnswer
        isAnswered = userAnswers.containsKey(currentIndex)
        isCorrect = answeredCorrectly[currentIndex] ?: false
        answeredCorrectly[currentIndex] = false
//        binding.clickedAnswer.text = currentItem.correctAnswer
        updateImage(currentItem.images)

        val multipleChoiseAdapter =
            MultipleChoiceAdapter(currentItem.answer, currentIndex, Constanta.PRETEST_ARG,this) { clickAnswer ->
                handleAnswerClick(clickAnswer)
            }

        binding.rvMultipleChoice.adapter = multipleChoiseAdapter
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
        userAnswers[currentIndex] = clickAnswer

        if (isAnswered) {
            if (isCorrect && clickAnswer != correctAnswer) {
                correctAnswerCount--
                isCorrect = false
            } else if (!isCorrect && clickAnswer == correctAnswer) {
                correctAnswerCount++
                isCorrect = true
            }
        } else {
            isAnswered = true
            if (clickAnswer == correctAnswer) {
                isCorrect = true
                answeredCorrectly[currentIndex] = true
                correctAnswerCount++
            } else {
                answeredCorrectly[currentIndex] = false
            }
        }
//        binding.counter.text = "skor $correctAnswerCount"
    }

    private fun navigateToNextQuestion(data: List<DataEntity>) {
        if (currentIndex < data.size - 1) {
            currentIndex++
            updateQuestion(data)
        }
    }

    private fun navigateToPreviousQuestion(data: List<DataEntity>) {
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
            finalResultViewModel.savePretestScore(correctAnswerCount,this)
            val intent = Intent(this, FirstVideoActivity::class.java)
            startActivity(intent)
            finish()
            builder.dismiss()
        }

        builder.setCanceledOnTouchOutside(false)
        builder.show()
    }
}
