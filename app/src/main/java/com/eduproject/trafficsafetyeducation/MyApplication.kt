package com.eduproject.trafficsafetyeducation

import android.app.Application
import com.eduproject.trafficsafetyeducation.core.di.databaseModule
import com.eduproject.trafficsafetyeducation.core.di.repositoryModule
import com.eduproject.trafficsafetyeducation.di.useCaseModule
import com.eduproject.trafficsafetyeducation.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MyApplication)
            androidLogger(org.koin.core.logger.Level.NONE)
            modules(
                listOf(
                    databaseModule,
                    repositoryModule,
                    useCaseModule,
                    viewModelModule
                )
            )

        }
    }
}