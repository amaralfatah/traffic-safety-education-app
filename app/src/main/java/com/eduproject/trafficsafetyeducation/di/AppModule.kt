package com.eduproject.trafficsafetyeducation.di

import com.eduproject.trafficsafetyeducation.core.domain.usecase.MainInteractor
import com.eduproject.trafficsafetyeducation.core.domain.usecase.MainUseCase
import com.eduproject.trafficsafetyeducation.finalresult.FinalResultViewModel
import com.eduproject.trafficsafetyeducation.posttest.PostTestViewModel
import com.eduproject.trafficsafetyeducation.pretest.PretestViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val useCaseModule = module {
    factory<MainUseCase> { MainInteractor(get()) }
}

val viewModelModule = module {
    viewModel { PretestViewModel(get()) }
    viewModel { PostTestViewModel(get()) }
    viewModel { FinalResultViewModel(get()) }
}