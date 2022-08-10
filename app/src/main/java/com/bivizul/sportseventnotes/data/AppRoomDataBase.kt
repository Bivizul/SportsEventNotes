package com.bivizul.sportseventnotes.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.bivizul.sportseventnotes.domain.model.CardItem

@Database(entities = [CardItem::class], version = 1)
abstract class AppRoomDatabase : RoomDatabase() {

    abstract fun getRoomDao(): CardListDao

}