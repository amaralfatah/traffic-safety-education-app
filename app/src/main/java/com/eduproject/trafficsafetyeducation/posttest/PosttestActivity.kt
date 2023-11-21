package com.eduproject.trafficsafetyeducation.posttest

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
        Log.d("updateQuestion", isCorrect.toString())
        Log.d("updateQuestion 2", answeredCorrectly.toString())
        for ((key, value) in answeredCorrectly) {
            Log.d("updateQuestion 3", "Key: $key, Value: $value" )
        }
        val multipleChoiseAdapter = MultipleChoiceAdapter(
            currentItem.answer,
            currentIndex,
            Constanta.POSTEST_ARG,
            this
        ) { clickAnswer ->
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

        Log.d("CheckCondition", isCorrect.toString())
        Log.d("CheckCondition 2", isAnswered.toString())
        if (isAnswered) { //question has been answer
            if (isCorrect && clickAnswer != correctAnswer) { //the prev answer was correct and the user clicked different answer
                correctAnswerCount--
                isCorrect = false
            } else if (!isCorrect && clickAnswer == correctAnswer) {//the prev answer was wrong and the user clicked correct answer
                Log.d("ObservePostest 3" , "here")
                correctAnswerCount++
                isCorrect = true
            }
            Log.d("ObservePostest 5" , clickAnswer)
        } else {
            isAnswered = true
            if (clickAnswer == correctAnswer) {
                isCorrect = true
                Log.d("ObservePostest 1" , answeredCorrectly.containsKey(currentIndex).toString())
                Log.d("ObservePostest 2", answeredCorrectly[currentIndex].toString())
                if (answeredCorrectly.containsKey(currentIndex) && !answeredCorrectly[currentIndex]!!) {
                    // If the question hasn't been answered correctly before, update the count
                    answeredCorrectly[currentIndex] = true
                    correctAnswerCount++
                }
            } else {
                answeredCorrectly[currentIndex] = false
            }
            Log.d("ObservePostest 4" , "here")
        }

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
}
