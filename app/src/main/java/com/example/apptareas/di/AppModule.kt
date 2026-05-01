package com.example.apptareas.di

import android.app.Application
import androidx.room.Room
import com.example.apptareas.data.local.dao.TareaDAO
import com.example.apptareas.data.local.database.AppDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun proveerDatabase(context : Application) : AppDatabase{
        return Room.databaseBuilder(
            context = context,
            klass = AppDatabase::class.java,
            name = "tareas_db"
        ).build()
    }

    @Provides
    @Singleton
    fun proveerDao(db : AppDatabase) : TareaDAO{
        return db.tareaDao()
    }
}