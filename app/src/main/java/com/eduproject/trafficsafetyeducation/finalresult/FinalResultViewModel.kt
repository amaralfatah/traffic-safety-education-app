package com.eduproject.trafficsafetyeducation.finalresult

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.eduproject.trafficsafetyeducation.core.domain.usecase.MainUseCase

class FinalResultViewModel(private val mainUseCase: MainUseCase): ViewModel() {

     val pretest = MutableLiveData<Int>()
     val postest = MutableLiveData<Int>()

    fun savePostestScore(score: Int, context: Context) = mainUseCase.savePostestScore(score,context)

    fun savePretestScore(score: Int, context: Context) = mainUseCase.savePretestScore(score,context)

    fun getPretestScore( context: Context): LiveData<Int> {
        val value= mainUseCase.getPretestScore(context)
        pretest.value = value
        return pretest
    }

    fun getPostestScore( context: Context): LiveData<Int> {
        val value= mainUseCase.getPostestScore(context)
        postest.value = value
        return postest
    }
}