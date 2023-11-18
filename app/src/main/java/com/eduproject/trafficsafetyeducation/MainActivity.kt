package com.eduproject.trafficsafetyeducation

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eduproject.trafficsafetyeducation.adapter.MultipleChoiceAdapter
import com.eduproject.trafficsafetyeducation.databinding.ActivityMainBinding
import com.eduproject.trafficsafetyeducation.materi.FirstVideoActivity
import com.eduproject.trafficsafetyeducation.pretest.PretestViewModel
import com.eduproject.trafficsafetyeducation.splash.OnBoardingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val pretestViewModel: PretestViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding


    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMultipleChoice.layoutManager = layoutManager


        pretestViewModel.pretest()
        pretestViewModel.postest()

        var currentIndex = 0
        var correctAnswer = ""
        var correctAnswerCount = 0
        val userAnswers = mutableMapOf<Int, String>()
        val answeredCorrectly = mutableMapOf<Int, Boolean>()
        pretestViewModel.pretest.observe(this) { data ->
            val firstItem = data.get(currentIndex)
            binding.pertanyaan.text = firstItem.question
            binding.soalNomor.text = "${currentIndex+1}"
            correctAnswer = firstItem.correctAnswer
            answeredCorrectly[currentIndex] = false

            val multipleChoiseAdapter = MultipleChoiceAdapter(firstItem.answer) { clickAnswer ->
                userAnswers[currentIndex] = clickAnswer
                binding.clickedAnswer.text = clickAnswer

                //Check if user already answer the question
                if (clickAnswer == correctAnswer && answeredCorrectly[currentIndex] != true) {
                    correctAnswerCount++
                    answeredCorrectly[currentIndex] = true
                    binding.counter.text = "skor $correctAnswerCount"
                }else if (clickAnswer != correctAnswer && answeredCorrectly[currentIndex] == true){
                    correctAnswerCount--
                    answeredCorrectly[currentIndex] = false
                    binding.counter.text = "skor $correctAnswerCount"
                } else if (clickAnswer != correctAnswer && answeredCorrectly[currentIndex] != true) {
                    // This is the case where the user changes their answer to an incorrect one.
                    // In this case, we don't need to do anything because the `correctAnswerCount`
                    // was not incremented for this question.
                }
            }

//            Log.d("CorrectAnswerScore", correctAnswerCount.toString())

            binding.nextButton.setOnClickListener {
                if (currentIndex < data.size - 1) {
                    currentIndex++
                    val nextItem = data.get(currentIndex)
                    binding.pertanyaan.text = nextItem.question
                    binding.soalNomor.text = "${currentIndex+1}"
                    correctAnswer = nextItem.correctAnswer
                    multipleChoiseAdapter.updateData(nextItem.answer)
                }
            }

            binding.prevButton.setOnClickListener {
                if (currentIndex > 0) {
                    currentIndex--
                    val prevItem = data.get(currentIndex)
                    binding.pertanyaan.text = prevItem.question
                    binding.soalNomor.text = "${currentIndex+1}"
                    correctAnswer = prevItem.correctAnswer
                    multipleChoiseAdapter.updateData(prevItem.answer)
                    if (userAnswers[currentIndex] != correctAnswer) {
                        correctAnswerCount--
                    }

                }
            }

            binding.rvMultipleChoice.adapter = multipleChoiseAdapter
        }
        binding.btnMateri.setOnClickListener {
            val intent = Intent(this, FirstVideoActivity::class.java)
            startActivity(intent)
        }
        binding.btnSplash.setOnClickListener {
            val intent = Intent(this, OnBoardingActivity::class.java)
            startActivity(intent)
        }


    }
}