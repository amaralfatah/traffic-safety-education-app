package com.eduproject.trafficsafetyeducation.core.data.source.local.room

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.DataEntity
import com.eduproject.trafficsafetyeducation.core.data.source.local.entity.Postest
import com.eduproject.trafficsafetyeducation.core.utils.Converters


@Database(entities = [DataEntity::class, Postest::class], version = 3, exportSchema = false)
@TypeConverters(Converters::class)
abstract class MainDatabase: RoomDatabase() {
    abstract fun mainDao(): MainDao
}