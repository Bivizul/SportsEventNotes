package com.bivizul.sportseventnotes.ui.screen.detailcard

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel
import com.bivizul.sportseventnotes.ui.screen.load.LoadScreen

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun DetailCard(
    navController: NavController,
    viewModel: ListCardsViewModel,
    cardId: String,
) {

    val cards by viewModel.getCardsList().observeAsState(listOf())
    Log.e("qwer", "DetailCard cards : $cards")

    if (cards.isEmpty()) {
        LoadScreen()
    } else {
        DetailCardScreen(
//            navController = , viewModel = , cardId =
            card = cards[cardId.toInt()]
        )
    }

    val bottomSheetState = rememberModalBottomSheetState(ModalBottomSheetValue.Hidden)
    val coroutineScope = rememberCoroutineScope()


}

@Composable
fun DetailCardScreen(
//    navController: NavController,
//    viewModel : ListCardsViewModel,
//    cardId : String,
    card: CardItem,
) {

//    val card = cards[cardId.toInt()]

    Scaffold(modifier = Modifier.fillMaxSize()) { paddingValues ->
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)) {
            Text(text = card.id.toString())
            Text(text = card.nameEvent)
            Text(text = card.team1)
            Text(text = card.team2)
        }
    }
}