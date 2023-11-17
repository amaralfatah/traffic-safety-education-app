package com.eduproject.trafficsafetyeducation.core.data.source.local.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import kotlinx.coroutines.flow.Flow


@Dao
interface MainDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(data: List<DataEntity>)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertPostestQuestion(data: List<Postest>)
    @Transaction
    @Query("SELECT * FROM pretest")
    fun getPretest(): Flow<List<DataEntity>>

    @Transaction
    @Query("SELECT * FROM postest")
    fun getPostest(): Flow<List<Postest>>
}