package com.bivizul.sportseventnotes.domain.case

import com.bivizul.sportseventnotes.domain.CardListRepository
import javax.inject.Inject

class GetCardItemUseCase @Inject constructor(private val cardListRepository: CardListRepository) {

    suspend operator fun invoke(cardItemId: Int) = cardListRepository.getCardItem(cardItemId)

}