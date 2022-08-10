package com.bivizul.sportseventnotes.ui.screen.detailcard

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.domain.Constants
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.screen.addeditcard.CardInner
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel
import com.bivizul.sportseventnotes.ui.screen.load.LoadScreen

@Composable
fun EditCard(
    navController: NavController,
    viewModel: ListCardsViewModel,
    cardId: String,
) {

    val cards by viewModel.getCardsList().observeAsState(listOf())

    when{
        cards.isEmpty() -> LoadScreen()
        else -> EditCardScreen(
            navController = navController,
            viewModel = viewModel,
            cards = cards,
            cardId = cardId
        )
    }


}

@Composable
fun EditCardScreen(
    navController: NavController,
    viewModel: ListCardsViewModel,
    cards : List<CardItem>,
    cardId: String,
) {

    val textButton = "Edit card"
    val textTitle = "Edit card"

                CardInner(
                    navController = navController,
                    viewModel = viewModel,
                    card = cards[cardId.toInt()],
                    typeFun = Constants.TYPE_FUN_EDIT,
                    textTitle =  textTitle,
                    textButton = textButton
                )
}
