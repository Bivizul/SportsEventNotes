package com.bivizul.sportseventnotes.data.di

import android.content.Context
import androidx.room.Room
import com.bivizul.sportseventnotes.data.AppRoomDatabase
import com.bivizul.sportseventnotes.domain.Constants.NAME_CARDS_DATABASE
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class DatabaseModule {

    @Provides
    fun provideDao(appRoomDatabase: AppRoomDatabase) = appRoomDatabase.getRoomDao()

    @Provides
    @Singleton
    fun ProvideAppRoomDatabase(@ApplicationContext appContext: Context): AppRoomDatabase {
        return Room.databaseBuilder(
            appContext,
            AppRoomDatabase::class.java,
            NAME_CARDS_DATABASE
        ).build()
    }

}