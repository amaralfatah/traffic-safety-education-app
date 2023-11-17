package com.eduproject.trafficsafetyeducation.core.domain.usecase

import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow

class MainInteractor(private val mainRepository: IMainRepository): MainUseCase {
    override fun getQueston(): Flow<List<DataEntity>> = mainRepository.getPretest()
    override fun getPostest(): Flow<List<Postest>>  = mainRepository.getPostest()
}