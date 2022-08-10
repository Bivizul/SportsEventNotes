package com.bivizul.sportseventnotes.ui.screen.listcards

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Card
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.Typography
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.navigation.Routes.EDIT_ROUTE
import com.example.ssjetpackcomposeswipeableview.SwipeAbleItemView
import com.example.ssjetpackcomposeswipeableview.SwipeDirection

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard2(
    navController: NavController,
    card: CardItem,
) {

    Card(
        onClick = {
            navController.navigate(EDIT_ROUTE + "/${card.id - 1}")
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
                text = card.event
            )
            Text(
                text = card.team1
            )
            Text(
                text = card.team2
            )
//            Text(
//                text = card.spread.toString()
//            )
//            Text(
//                text = card.total.toString()
//            )
//            Text(
//                text = card.money.toString()
//            )
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(
    navController: NavController,
    card: CardItem,
    viewModel: ListCardsViewModel = hiltViewModel(),
) {

//    val context = LocalContext.current
    val swipeDirection: SwipeDirection? = null

    SwipeAbleItemView(
        leftViewIcons = arrayListOf(
            Triple(
                rememberVectorPainter(image = Icons.Filled.Delete),
                Color.White,
                "btnDeleteLeft"
            )
        ),
        rightViewIcons = arrayListOf(
            Triple(
                rememberVectorPainter(image = Icons.Filled.Edit),
                Color.White,
                "btnEditRight"
            )
        ),
        position = 0,
        swipeDirection = swipeDirection ?: SwipeDirection.BOTH,
        onClick = {
            when (it.second) {
                "btnDeleteLeft" -> {
                    Log.e("qwer", "btnDeleteLeft")
                    viewModel.deleteCardItem(cardItem = card)
                }
                "btnEditRight" -> {
                    Log.e("qwer", "btnEditRight")
                    navController.navigate(EDIT_ROUTE + "/${card.id - 1}")
                }
            }
        },
        leftViewWidth = 70.dp,
        rightViewWidth = 70.dp,
        height = 160.dp,
        leftViewBackgroundColor = MaterialTheme.colors.error,
        rightViewBackgroundColor = MaterialTheme.colors.secondary,
        cornerRadius = 8.dp,
        leftSpace = 10.dp,
        rightSpace = 10.dp,
        fractionalThreshold = 0.3f
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(160.dp)
                .background(MaterialTheme.colors.primary, shape = RoundedCornerShape(8.dp)),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = card.event,
                style = MaterialTheme.typography.h6
            )
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = card.date,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = card.time,
                    style = MaterialTheme.typography.h6
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(
                    text = card.team1,
                    style = MaterialTheme.typography.h6
                )
                Text(
                    text = "VS",
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = card.team2,
                    style = MaterialTheme.typography.h6
                )
            }

            Text(
                text = "Coefficient : ${card.coefficient}",
                style = MaterialTheme.typography.h6
            )
            Text(
                text = "Income/Risk : ${card.incomeRisk}",
                style = MaterialTheme.typography.h6
            )
        }
    }
}
