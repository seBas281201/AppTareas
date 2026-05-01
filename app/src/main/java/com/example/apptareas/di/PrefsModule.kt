package com.example.apptareas.di

import android.content.Context
import com.example.apptareas.ui.theme.ThemePreferences
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PrefsModule {

    @Provides
    @Singleton
    fun proveerThemePreferences(@ApplicationContext context: Context): ThemePreferences =
        ThemePreferences(context)

}