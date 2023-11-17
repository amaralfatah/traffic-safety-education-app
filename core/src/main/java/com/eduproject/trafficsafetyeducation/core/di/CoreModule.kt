package com.eduproject.trafficsafetyeducation.core.di

import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.eduproject.trafficsafetyeducation.core.data.MainRepository
import com.eduproject.trafficsafetyeducation.core.data.source.local.LocalDataSource
import com.eduproject.trafficsafetyeducation.core.data.source.local.room.MainDao
import com.eduproject.trafficsafetyeducation.core.data.source.local.room.MainDatabase
import com.eduproject.trafficsafetyeducation.core.domain.repository.IMainRepository
import com.eduproject.trafficsafetyeducation.core.utils.InitialDataSource
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module


val databaseModule = module {
    factory { get<MainDatabase>().mainDao() }
    single { CoroutineScope(Dispatchers.IO) }
    single {
        Room.databaseBuilder(
            androidContext(),
            MainDatabase::class.java, "mainDatabase.db"
        ).fallbackToDestructiveMigration()
            .addCallback(object : RoomDatabase.Callback(){
                override fun onCreate(db: SupportSQLiteDatabase) {
                    super.onCreate(db)
                    val applicationScope = CoroutineScope(SupervisorJob())
                    applicationScope.launch {
                        val mainDao = get<MainDao>()

                        mainDao.insertData(InitialDataSource.getQuestions())
                        mainDao.insertPostestQuestion(InitialDataSource.postestQuestions())

                    }
                }
            }).build()
    }
}


val repositoryModule = module {
    single { LocalDataSource(get()) }
    single<IMainRepository>{MainRepository(get())}
}