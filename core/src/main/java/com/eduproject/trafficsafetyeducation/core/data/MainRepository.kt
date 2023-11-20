package com.eduproject.trafficsafetyeducation.core.data

import android.content.Context
import com.eduproject.trafficsafetyeducation.core.data.source.local.LocalDataSource
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow

class MainRepository(
    private val localDatabase: LocalDataSource
):IMainRepository {
    override suspend fun populateDatabaseIfEmpty() = localDatabase.populateDatabaseIfEmpty()

    override fun getPretest(): Flow<List<DataEntity>> = localDatabase.getPretestData()
    override fun getPostest(): Flow<List<Postest>>  = localDatabase.getPostestData()
    override fun savePretestScore(score: Int, context: Context) = localDatabase.savePretestScore(score,context)

    override fun savePostestScore(score: Int, context: Context) = localDatabase.savePostestScore(score, context)

    override fun getPretestScore(context: Context): Int = localDatabase.getPretestScore(context)

    override fun getPostestScore(context: Context): Int = localDatabase.getPostestScore(context)

}