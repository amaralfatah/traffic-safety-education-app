package com.eduproject.trafficsafetyeducation.core.data

import com.eduproject.trafficsafetyeducation.core.data.source.local.LocalDataSource
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.domain.repository.IMainRepository
import kotlinx.coroutines.flow.Flow

class MainRepository(
    private val localDatabase: LocalDataSource
):IMainRepository {
    override fun getPretest(): Flow<List<DataEntity>> = localDatabase.getPretestData()
    override fun getPostest(): Flow<List<Postest>>  = localDatabase.getPostestData()

}