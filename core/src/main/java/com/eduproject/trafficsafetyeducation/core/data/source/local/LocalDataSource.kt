package com.eduproject.trafficsafetyeducation.core.data.source.local

import android.content.Context
import android.util.Log
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.data.source.local.preference.ScoreSharedPreference
import com.eduproject.trafficsafetyeducation.core.data.source.local.room.MainDao
import com.eduproject.trafficsafetyeducation.core.utils.InitialDataSource
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.flow

class LocalDataSource(private val mainDao: MainDao) {
    suspend fun populateDatabaseIfEmpty() {
        val pretestList = mainDao.getPretest().first()
        if (pretestList.isEmpty()) {
            mainDao.insertData(InitialDataSource.getQuestions())
        }

        val postestList = mainDao.getPostest().first()
        if (postestList.isEmpty()) {
            mainDao.insertPostestQuestion(InitialDataSource.postestQuestions())
        }
    }

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

    fun savePretestScore(score: Int, context: Context){
        val pref = ScoreSharedPreference(context)
        pref.setPretestScore(score)
    }
    fun savePostestScore(score: Int, context: Context){
        val pref = ScoreSharedPreference(context)
        pref.setPostestScore(score)
    }

    fun getPretestScore( context: Context): Int{
        val pref = ScoreSharedPreference(context)
        return pref.getPretest()
    }
    fun getPostestScore( context: Context): Int {
        val pref = ScoreSharedPreference(context)
        return pref.getPostest()
    }

}