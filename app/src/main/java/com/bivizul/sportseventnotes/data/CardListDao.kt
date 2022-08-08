package com.bivizul.sportseventnotes.data

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bivizul.sportseventnotes.domain.model.CardItem

@Dao
interface CardListDao {

    @Query("SELECT * FROM CARDS_TABLE")
    fun getCardList(): LiveData<List<CardItem>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCardItem(cardItem: CardItem)

    @Query("DELETE FROM CARDS_TABLE WHERE id = :cardItemId")
    suspend fun deleteCardItem(cardItemId: Int)

    @Query("SELECT * FROM CARDS_TABLE WHERE id = :cardItemId LIMIT 1")
    suspend fun getCardItem(cardItemId: Int): CardItem

}