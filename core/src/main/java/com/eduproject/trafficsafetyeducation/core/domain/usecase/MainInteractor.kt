package com.eduproject.trafficsafetyeducation.core.domain.usecase

import android.content.Context
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow

class MainInteractor(private val mainRepository: IMainRepository) : MainUseCase {
    override suspend fun populateDatabaseIfEmpty() = mainRepository.populateDatabaseIfEmpty()

    override fun getQueston(): Flow<List<DataEntity>> = mainRepository.getPretest()
    override fun getPostest(): Flow<List<Postest>> = mainRepository.getPostest()
    override fun savePretestScore(score: Int, context: Context) =
        mainRepository.savePretestScore(score, context)

    override fun savePostestScore(score: Int, context: Context) =
        mainRepository.savePostestScore(score, context)

    override fun getPretestScore(context: Context): Int = mainRepository.getPretestScore(context)

    override fun getPostestScore(context: Context): Int = mainRepository.getPostestScore(context)
}