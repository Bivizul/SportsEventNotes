package com.bivizul.sportseventnotes.domain

import androidx.lifecycle.LiveData
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.domain.model.LP
import com.bivizul.sportseventnotes.domain.model.ResServ
import retrofit2.Response

interface CardListRepository {

    suspend fun addCardItem(cardItem: CardItem)

    suspend fun deleteCardItem(cardItem: CardItem)

    suspend fun editCardItem(cardItem: CardItem)

    suspend fun getCardItem(cardItemId: Int): CardItem

    suspend fun getCardList(): LiveData<List<CardItem>>

    suspend fun getRespServ(lp:LP): Response<ResServ>

}