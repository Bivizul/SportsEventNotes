package com.bivizul.sportseventnotes.ui.screen.addcard

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.navigation.Routes.LIST_CARD_ROUTE
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel

@Composable
fun AddCard(
    navController: NavController,
    viewModel: ListCardsViewModel,
) {

    var nameEvent by remember { mutableStateOf("") }
    var team1 by remember { mutableStateOf("") }
    var team2 by remember { mutableStateOf("") }
    var isButtonEnabled by remember { mutableStateOf(false) }
    val allIsNotEmpty = nameEvent.isNotEmpty() && team1.isNotEmpty() && team2.isNotEmpty()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Add card")

            OutlinedTextField(
                value = nameEvent,
                onValueChange = {
                    nameEvent = it
                    isButtonEnabled = allIsNotEmpty
                },
                label = { Text(text = "name event") },
                isError = nameEvent.isEmpty()
            )

            OutlinedTextField(
                value = team1,
                onValueChange = {
                    team1 = it
                    isButtonEnabled = allIsNotEmpty
                },
                label = { Text(text = "team 1") },
                isError = team1.isEmpty()
            )

            OutlinedTextField(
                value = team2,
                onValueChange = {
                    team2 = it
                    isButtonEnabled = allIsNotEmpty
                }
            )

            Button(
                onClick = {
                    viewModel.addCardItem(
                        cardItem = CardItem(
                            nameEvent = nameEvent,
                            team1 = team1,
                            team2 = team2
                        )
                    )
                    navController.navigate(LIST_CARD_ROUTE)
                },
                enabled = isButtonEnabled
            ) {
                Text(text = "Add new card")
            }
        }
    }
}