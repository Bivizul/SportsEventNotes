package com.bivizul.sportseventnotes.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.bivizul.sportseventnotes.domain.Constants.NAME_CARDS_DATABASE
import com.bivizul.sportseventnotes.domain.model.CardItem

@Database(entities = [CardItem::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getRoomDao(): CardListDao

//    companion object {
//
//        @Volatile
//        private var INSTANCE: AppRoomDatabase? = null
//
//        fun getInstance(context: Context): AppRoomDatabase {
//            return if (INSTANCE == null) {
//                INSTANCE = Room.databaseBuilder(
//                    context,
//                    AppRoomDatabase::class.java,
//                    NAME_CARDS_DATABASE
//                ).build()
//                INSTANCE as AppRoomDatabase
//            } else {
//                INSTANCE as AppRoomDatabase
//            }
//        }
//    }
}