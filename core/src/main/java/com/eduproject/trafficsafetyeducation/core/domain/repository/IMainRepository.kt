package com.eduproject.trafficsafetyeducation.core.domain.repository

import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import kotlinx.coroutines.flow.Flow
interface IMainRepository {

    suspend fun populateDatabaseIfEmpty()
    fun getPretest(): Flow<List<DataEntity>>

    fun getPostest(): Flow<List<Postest>>
}