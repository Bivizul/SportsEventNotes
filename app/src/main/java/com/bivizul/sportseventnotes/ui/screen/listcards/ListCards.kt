package com.bivizul.sportseventnotes.ui.screen.listcards

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.R
import com.bivizul.sportseventnotes.domain.Constants.ADD_ICONS
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.navigation.Routes.ADD_ROUTE

@Composable
fun ListCards(
    navController: NavController,
    viewModel: ListCardsViewModel,
) {

    val cardList by viewModel.getCardsList().observeAsState(listOf())

    ListCardsScreen(
        navController = navController,
        cardsList = cardList
    )

}

@Composable
fun ListCardsScreen(
    navController: NavController,
    cardsList: List<CardItem>,
) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(route = ADD_ROUTE)
            }) {
                Icon(
                    painter = painterResource(id = R.drawable.ic_add_24), contentDescription = "add"
//                    imageVector = Icons.Filled.Add,
//                    imageVector = Image(painter = painterResource(id = R.drawable.ic_add_24), contentDescription = "add"),
//                    contentDescription = ADD_ICONS,
//                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        LazyColumn(modifier = Modifier.padding(paddingValues)) {
            items(cardsList) { cardItem ->
                ItemCard(navController = navController, card = cardItem)
            }
        }

    }
}


