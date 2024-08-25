package com.gms.foodtracker.di

import android.app.Application
import android.content.Context.MODE_PRIVATE
import android.content.SharedPreferences
import com.gms.core.data.preferences.DefaultPreferences
import com.gms.core.domain.preferences.Preferences
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
    fun provideSharedPreferences(application: Application): SharedPreferences {
        return application.getSharedPreferences("shared_pref", MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providePreferences(sharedPreferences: SharedPreferences): Preferences {
        return DefaultPreferences(sharedPreferences)
    }
}