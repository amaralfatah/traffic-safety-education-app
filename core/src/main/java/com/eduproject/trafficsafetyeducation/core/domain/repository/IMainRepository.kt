package com.eduproject.trafficsafetyeducation.core.domain.repository

import android.content.Context
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import kotlinx.coroutines.flow.Flow
interface IMainRepository {

    suspend fun populateDatabaseIfEmpty()
    fun getPretest(): Flow<List<DataEntity>>

    fun getPostest(): Flow<List<Postest>>

    fun savePretestScore(score: Int, context: Context)

    fun savePostestScore(score: Int, context: Context)

    fun getPretestScore( context: Context): Int

    fun getPostestScore( context: Context): Int
}