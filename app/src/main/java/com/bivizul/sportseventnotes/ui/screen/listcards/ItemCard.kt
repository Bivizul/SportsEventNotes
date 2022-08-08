package com.bivizul.sportseventnotes.ui.screen.listcards

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.navigation.Routes.DETAIL_ROUTE

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(
    navController: NavController,
    card: CardItem,
) {

    Card(
        onClick = {
            navController.navigate(DETAIL_ROUTE + "/${card.id}")
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp, horizontal = 24.dp),
        elevation = 6.dp
    ) {
        Column(
            modifier = Modifier.padding(vertical = 8.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = card.nameEvent
            )
            Text(
                text = card.team1
            )
            Text(
                text = card.team2
            )
            Text(
                text = card.spread.toString()
            )
            Text(
                text = card.total.toString()
            )
            Text(
                text = card.money.toString()
            )
        }
    }

}