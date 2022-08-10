package com.bivizul.sportseventnotes.ui.screen.listcards

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bivizul.sportseventnotes.data.CardListRepositoryImpl
import com.bivizul.sportseventnotes.domain.case.AddCardItemUseCase
import com.bivizul.sportseventnotes.domain.case.DeleteCardItemUseCase
import com.bivizul.sportseventnotes.domain.case.EditCardItemUseCase
import com.bivizul.sportseventnotes.domain.case.GetCardListUseCase
import com.bivizul.sportseventnotes.domain.model.CardItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListCardsViewModel @Inject constructor(cardListRepositoryImpl: CardListRepositoryImpl) :
    ViewModel() {

    private val addCardItemUseCase = AddCardItemUseCase(cardListRepositoryImpl)
    private val deleteCardItemUseCase = DeleteCardItemUseCase(cardListRepositoryImpl)
    private val editCardItemUseCase = EditCardItemUseCase(cardListRepositoryImpl)
    private val getCardListUseCase = GetCardListUseCase(cardListRepositoryImpl)

    fun getCardsList() = getCardListUseCase()

    fun addCardItem(cardItem: CardItem) {
        viewModelScope.launch(Dispatchers.IO) {
            addCardItemUseCase(cardItem)
        }
    }

    fun editCardItem(cardItem: CardItem) {
        viewModelScope.launch(Dispatchers.IO) {
            editCardItemUseCase(cardItem)
        }
    }

    fun deleteCardItem(cardItem: CardItem) {
        viewModelScope.launch(Dispatchers.IO) {
            deleteCardItemUseCase(cardItem)
        }
    }

}