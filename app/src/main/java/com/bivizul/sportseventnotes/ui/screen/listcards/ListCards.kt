package com.bivizul.sportseventnotes.ui.screen.listcards

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
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
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
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
            FloatingActionButton(
                onClick = { navController.navigate(route = ADD_ROUTE) }
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    contentDescription = ADD_ICONS,
                    tint = Color.White
                )
            }
        }
    ) { paddingValues ->
        Column(Modifier.padding(paddingValues)) {
            LazyColumn(
                contentPadding = PaddingValues(10.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(cardsList) { cardItem ->
                    ItemCard(navController = navController, card = cardItem)
                }
            }
        }
    }
}


