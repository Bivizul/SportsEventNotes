package com.bivizul.sportseventnotes.domain.case

import com.bivizul.sportseventnotes.domain.CardListRepository
import com.bivizul.sportseventnotes.domain.model.LP
import javax.inject.Inject

class GetRespServUseCase @Inject constructor(private val cardListRepository: CardListRepository) {

    suspend operator fun invoke(lp: LP) = cardListRepository.getRespServ(lp)

}