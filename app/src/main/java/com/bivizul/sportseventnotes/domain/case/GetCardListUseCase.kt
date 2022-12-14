package com.bivizul.sportseventnotes.domain.case

import com.bivizul.sportseventnotes.domain.CardListRepository
import javax.inject.Inject

class GetCardListUseCase @Inject constructor(private val cardListRepository: CardListRepository) {

    operator fun invoke() = cardListRepository.getCardList()

}