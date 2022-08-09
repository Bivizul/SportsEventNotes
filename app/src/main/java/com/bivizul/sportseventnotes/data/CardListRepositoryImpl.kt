package com.bivizul.sportseventnotes.data

import androidx.lifecycle.LiveData
import com.bivizul.sportseventnotes.domain.CardListRepository
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.domain.model.LP
import javax.inject.Inject

class CardListRepositoryImpl @Inject constructor(
    private val apiCards: ApiCards,
    private val cardListDao: CardListDao,
) : CardListRepository {

    //    override suspend fun getCardList(): LiveData<List<CardItem>> = cardListDao.getCardList()
    override fun getCardList(): LiveData<List<CardItem>> = cardListDao.getCardList()

    override suspend fun addCardItem(cardItem: CardItem) = cardListDao.addCardItem(cardItem)

    override suspend fun deleteCardItem(cardItem: CardItem) =
        cardListDao.deleteCardItem(cardItem.id)

    // add работает одновременно как добавление так и замена
    override suspend fun editCardItem(cardItem: CardItem) = cardListDao.addCardItem(cardItem)

    override suspend fun getCardItem(cardItemId: Int): CardItem =
        cardListDao.getCardItem(cardItemId)


    override suspend fun getRespServ(lp: LP) = apiCards.getResServ(lp)
}