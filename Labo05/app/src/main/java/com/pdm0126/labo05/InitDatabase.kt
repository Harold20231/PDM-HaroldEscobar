package com.pdm0126.labo05

import android.app.Application
import androidx.room.Room

class InitDatabase : Application() {
    companion object {
        lateinit var database: AppDatabase
            private set
    }

    override fun onCreate() {
        super.onCreate()
        database = Room.databaseBuilder(
            this,
            AppDatabase::class.java,
            "AppDatabase"
        ).fallbackToDestructiveMigration(false).build()
    }
}
