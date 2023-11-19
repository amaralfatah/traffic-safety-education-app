package com.eduproject.trafficsafetyeducation

import android.content.Intent
import android.os.Bundle
import android.util.Log
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
        var correctAnswer: String
        var correctAnswerCount = 0
        var isAnswered: Boolean
        var isCorrect: Boolean
        val userAnswers = mutableMapOf<Int, String>()
        val answeredCorrectly = mutableMapOf<Int, Boolean>()

        pretestViewModel.pretest.observe(this) { data ->
            val firstItem = data[currentIndex]
            binding.pertanyaan.text = firstItem.question
            binding.soalNomor.text = "${currentIndex + 1}"
            correctAnswer = firstItem.correctAnswer
            isAnswered = userAnswers.containsKey(currentIndex)
            isCorrect = answeredCorrectly[currentIndex] ?: false
            answeredCorrectly[currentIndex] = false

            val multipleChoiseAdapter = MultipleChoiceAdapter(firstItem.answer) { clickAnswer ->
                userAnswers[currentIndex] = clickAnswer
                binding.clickedAnswer.text = clickAnswer
                Log.d("CorrectAnswer", firstItem.correctAnswer)



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
                binding.counter.text = "skor $correctAnswerCount"

            }

            //Kondisi 1 : Jawaban benar user sudah belum pernah menjawab count++
            //kondisi 2 :Jawaban salah user belum pernah menjawab
            // kondisi 3 : Jawaban benar->salah user sudah pernah menjawab count--
            //kondisi 4:  jawaban salah->benar user udah pernah manjawab count++


            binding.nextButton.setOnClickListener {
                if (currentIndex < data.size - 1) {
                    currentIndex++
                    val nextItem = data[currentIndex]
                    binding.pertanyaan.text = nextItem.question
                    binding.soalNomor.text = "${currentIndex + 1}"
                    correctAnswer = nextItem.correctAnswer
                    isAnswered = userAnswers.containsKey(currentIndex)
                    isCorrect = answeredCorrectly[currentIndex] ?: false
                    multipleChoiseAdapter.updateData(nextItem.answer)
                }
            }

            binding.prevButton.setOnClickListener {
                if (currentIndex > 0) {
                    currentIndex--
                    val currentItem = data[currentIndex]
                    binding.pertanyaan.text = currentItem.question
                    binding.soalNomor.text = "${currentIndex + 1}"
                    correctAnswer = currentItem.correctAnswer
                    isAnswered = userAnswers.containsKey(currentIndex)
                    isCorrect = answeredCorrectly[currentIndex] ?: false
                    multipleChoiseAdapter.updateData(currentItem.answer)

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