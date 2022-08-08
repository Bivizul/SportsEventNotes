package com.bivizul.sportseventnotes.domain.case

import com.bivizul.sportseventnotes.domain.CardListRepository
import com.bivizul.sportseventnotes.domain.model.CardItem
import javax.inject.Inject

class AddCardItemUseCase @Inject constructor(private val cardListRepository: CardListRepository) {

    suspend operator fun invoke(cardItem: CardItem) = cardListRepository.addCardItem(cardItem)

}