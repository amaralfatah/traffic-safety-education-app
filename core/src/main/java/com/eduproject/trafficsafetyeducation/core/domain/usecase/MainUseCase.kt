package com.eduproject.trafficsafetyeducation.core.domain.usecase

import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import kotlinx.coroutines.flow.Flow

interface MainUseCase {

    suspend fun populateDatabaseIfEmpty()
    fun getQueston(): Flow<List<DataEntity>>

    fun getPostest(): Flow<List<Postest>>
}