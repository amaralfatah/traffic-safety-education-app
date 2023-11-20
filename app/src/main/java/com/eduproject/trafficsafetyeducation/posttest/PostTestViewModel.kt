package com.eduproject.trafficsafetyeducation.posttest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.domain.usecase.MainUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PostTestViewModel(private val mainUseCase: MainUseCase): ViewModel() {

    private val _postest = MutableLiveData<List<Postest>>()
    val postest: LiveData<List<Postest>> = _postest

    fun postest(){
        mainUseCase.getPostest()
            .onEach {
                _postest.value =it
            }
            .launchIn(viewModelScope)
    }
}