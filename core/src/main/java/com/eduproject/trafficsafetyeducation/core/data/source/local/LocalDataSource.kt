package com.eduproject.trafficsafetyeducation.core.data.source.local

import android.util.Log
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.data.source.local.room.MainDao
import kotlinx.coroutines.flow.flow

class LocalDataSource(private val mainDao: MainDao) {

    fun getPretestData(): kotlinx.coroutines.flow.Flow<List<DataEntity>> = flow{
        try {
            mainDao.getPretest().collect{
                emit(it)
            }
        }catch (e:Exception){
            Log.d("Error when getPretestData", e.message.toString())
        }

    }

    fun getPostestData(): kotlinx.coroutines.flow.Flow<List<Postest>> = flow{
        try {
            mainDao.getPostest().collect{
                emit(it)
            }
        }catch (e:Exception){
            Log.d("Error when getPosttest", e.message.toString())
        }

    }

}