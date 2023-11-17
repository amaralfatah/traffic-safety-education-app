package com.eduproject.trafficsafetyeducation.pretest

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.domain.usecase.MainUseCase
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class PretestViewModel(private val mainUseCase: MainUseCase): ViewModel() {

    private val _pretest= MutableLiveData<List<DataEntity>>()
    val pretest: LiveData<List<DataEntity>> = _pretest

    private val _postest = MutableLiveData<List<Postest>>()
    val postest: LiveData<List<Postest>> = _postest
    fun pretest(){
        mainUseCase.getQueston()
            .onEach {
                _pretest.value =it
            }
            .launchIn(viewModelScope)
    }

    fun postest(){
        mainUseCase.getPostest()
            .onEach {
                _postest.value =it
            }
            .launchIn(viewModelScope)
    }
}