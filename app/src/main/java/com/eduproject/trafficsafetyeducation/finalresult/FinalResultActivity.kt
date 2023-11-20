package com.eduproject.trafficsafetyeducation.finalresult

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.eduproject.trafficsafetyeducation.databinding.ActivityFinalResultBinding
import com.eduproject.trafficsafetyeducation.pretest.PreTestActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class FinalResultActivity : AppCompatActivity() {

    private val finalResultViewModel: FinalResultViewModel by viewModel()
    private lateinit var binding: ActivityFinalResultBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFinalResultBinding.inflate(layoutInflater)
        setContentView(binding.root)


        finalResultViewModel.getPretestScore(this).observe(this) {
            binding.tvPretestValue.text = it.toString()
        }
        finalResultViewModel.getPostestScore(this).observe(this) {
            binding.tvPostestValue.text = it.toString()
        }
        var pretestScore = finalResultViewModel.pretest.value?: 0
        var postestScore = finalResultViewModel.postest.value?: 0

        Log.d("result Pretest", pretestScore.toString())
        Log.d("result postest", postestScore.toString())
        val result = (pretestScore + postestScore) * 2
        binding.tvnilaiakhir.text = result.toString()

        binding.mulaiLagiBtn.setOnClickListener {
            finalResultViewModel.savePretestScore(0,this)
            finalResultViewModel.savePostestScore(0,this)
            val intent = Intent(this, PreTestActivity::class.java)
            startActivity(intent)
            finish()
        }


    }
}