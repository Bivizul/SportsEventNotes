package com.bivizul.sportseventnotes.ui.screen.listcards

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.rememberVectorPainter
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.R
import com.bivizul.sportseventnotes.domain.Constants.BTN_DELETE_RIGHT
import com.bivizul.sportseventnotes.domain.Constants.BTN_EDIT_LEFT
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.navigation.Routes.EDIT_ROUTE
import com.example.ssjetpackcomposeswipeableview.SwipeAbleItemView
import com.example.ssjetpackcomposeswipeableview.SwipeDirection

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ItemCard(
    navController: NavController,
    card: CardItem,
    viewModel: ListCardsViewModel = hiltViewModel(),
) {

    val swipeDirection: SwipeDirection? = null

    SwipeAbleItemView(
        leftViewIcons = arrayListOf(
            Triple(
                rememberVectorPainter(image = Icons.Filled.Edit),
                Color.White,
                BTN_EDIT_LEFT
            )
        ),
        rightViewIcons = arrayListOf(
            Triple(
                rememberVectorPainter(image = Icons.Filled.Delete),
                Color.White,
                BTN_DELETE_RIGHT
            )
        ),
        position = 0,
        swipeDirection = swipeDirection ?: SwipeDirection.BOTH,
        onClick = {
            when (it.second) {
                BTN_EDIT_LEFT -> {
                    navController.navigate(EDIT_ROUTE + "/${card.id - 1}")
                }
                BTN_DELETE_RIGHT -> {
                    viewModel.deleteCardItem(cardItem = card)

                }
            }
        },
        leftViewWidth = 70.dp,
        rightViewWidth = 70.dp,
        height = 160.dp,
        leftViewBackgroundColor = MaterialTheme.colors.secondary,
        rightViewBackgroundColor = MaterialTheme.colors.error,
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
                    text = stringResource(R.string.vs),
                    fontWeight = FontWeight.Bold,
                    style = MaterialTheme.typography.h6,
                )
                Text(
                    text = card.team2,
                    style = MaterialTheme.typography.h6
                )
            }

            Text(
                text = stringResource(R.string.coefficient_plus) + card.coefficient,
                style = MaterialTheme.typography.h6
            )
            Text(
                text = stringResource(R.string.income_risk_plus) + card.incomeRisk,
                style = MaterialTheme.typography.h6
            )
        }
    }
}
