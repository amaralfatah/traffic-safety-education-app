package com.eduproject.trafficsafetyeducation

import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eduproject.trafficsafetyeducation.adapter.MultipleChoiceAdapter
import com.eduproject.trafficsafetyeducation.databinding.ActivityMainBinding
import com.eduproject.trafficsafetyeducation.databinding.CustomViewLayoutBinding
import com.eduproject.trafficsafetyeducation.materi.FirstVideoActivity
import com.eduproject.trafficsafetyeducation.pretest.PretestViewModel
import com.eduproject.trafficsafetyeducation.splash.OnBoardingActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val pretestViewModel: PretestViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding
    private lateinit var customView: CustomViewLayoutBinding
    private var correctAnswerCount: Int = 0


    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvMultipleChoice.layoutManager = layoutManager

        pretestViewModel.pretest()

        val test = "dishub_logo"



        Log.d("Code", R.drawable.dishub_logo.toString())

        var currentIndex = 0
        var correctAnswer: String
//        var correctAnswerCount = 0
        var isAnswered: Boolean
        var isCorrect: Boolean
        val userAnswers = mutableMapOf<Int, String>()
        val answeredCorrectly = mutableMapOf<Int, Boolean>()

        pretestViewModel.pretest.observe(this) { data ->

            Log.d("DATA", data.toString())
            val firstItem = data[currentIndex]
            binding.pertanyaan.text = firstItem.question
            binding.soalNomor.text = "${currentIndex + 1}"
            correctAnswer = firstItem.correctAnswer
            isAnswered = userAnswers.containsKey(currentIndex)
            isCorrect = answeredCorrectly[currentIndex] ?: false
            answeredCorrectly[currentIndex] = false


            val resID = resources.getIdentifier(firstItem.images, "drawable", packageName)
            if (resID != 0) {
                binding.IVSoal.visibility = View.VISIBLE
                binding.IVSoal.setImageResource(resID)
            }else {
                // Jika gambar tidak ditemukan, lakukan tindakan yang sesuai (misalnya, set gambar default)\
                binding.IVSoal.visibility = View.GONE
            }
            if (resID != 0) {
                binding.IVSoal.setImageResource(resID)
            }

            val multipleChoiseAdapter = MultipleChoiceAdapter(firstItem.answer, currentIndex, this) { clickAnswer ->
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
            //kondisi 3 : Jawaban benar->salah user sudah pernah menjawab count--
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
                    val resID = resources.getIdentifier(nextItem.images, "drawable", packageName)

                    if (resID != 0) {
                        binding.IVSoal.visibility = View.VISIBLE
                        binding.IVSoal.setImageResource(resID)
                    }else {
                        // Jika gambar tidak ditemukan, lakukan tindakan yang sesuai (misalnya, set gambar default)\
                        binding.IVSoal.visibility = View.GONE
                    }
                    multipleChoiseAdapter.updateData(nextItem.answer, currentIndex)
                }
               multipleChoiseAdapter.updateSelectedPosition(-1)
                //sampai soal terakhir dan sudah menjawab

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
                    val resID = resources.getIdentifier(currentItem.images, "drawable", packageName)

                    if (resID != 0) {
                        binding.IVSoal.visibility = View.VISIBLE
                        binding.IVSoal.setImageResource(resID)
                    }else {
                        // Jika gambar tidak ditemukan, lakukan tindakan yang sesuai (misalnya, set gambar default)\
                        binding.IVSoal.visibility = View.GONE
                    }
                    multipleChoiseAdapter.updateData(currentItem.answer, currentIndex)

                }
            }
//            Log.d("CurrentIndex", currentIndex.toString())
            binding.rvMultipleChoice.adapter = multipleChoiseAdapter

        }
    }

    fun customDialog() {
        val builder = AlertDialog.Builder(this, R.style.CustomAlertDialog)
            .create()
        customView = CustomViewLayoutBinding.inflate(layoutInflater)
        builder.setView(customView.root)

        customView.score.text = correctAnswerCount.toString()
        customView.dialogDismissButton.setOnClickListener {
            builder.dismiss()
        }



        builder.setCanceledOnTouchOutside(false)
        builder.show()
    }
}