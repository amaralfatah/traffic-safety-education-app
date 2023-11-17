package com.eduproject.trafficsafetyeducation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.eduproject.trafficsafetyeducation.adapter.MultipleChoiceAdapter
import com.eduproject.trafficsafetyeducation.databinding.ActivityMainBinding
import com.eduproject.trafficsafetyeducation.pretest.PretestViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val pretestViewModel: PretestViewModel by viewModel()
    private lateinit var binding: ActivityMainBinding


    //
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false)
        binding.rvMultipleChoice.layoutManager = layoutManager


        pretestViewModel.pretest()
        pretestViewModel.postest()

        var currentIndex = 0
        pretestViewModel.pretest.observe(this){data->
            val firstItem = data.get(currentIndex)
            binding.pertanyaan.text = firstItem.question
            val multipleChoiseAdapter= MultipleChoiceAdapter(firstItem.answer)


            binding.nextButton.setOnClickListener {
                if (currentIndex < data.size - 1) {
                    currentIndex++
                    val nextItem = data.get(currentIndex)
                    binding.pertanyaan.text = nextItem.question
                    multipleChoiseAdapter.updateData(nextItem.answer)
                }
            }

            binding.rvMultipleChoice.adapter = multipleChoiseAdapter




        }


    }
}