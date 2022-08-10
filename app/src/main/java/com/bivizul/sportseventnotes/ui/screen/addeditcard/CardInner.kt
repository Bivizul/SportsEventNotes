package com.bivizul.sportseventnotes.ui.screen.addeditcard

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.R
import com.bivizul.sportseventnotes.domain.Constants.TEXT_DATE_BUTTON
import com.bivizul.sportseventnotes.domain.Constants.TEXT_TIME_BUTTON
import com.bivizul.sportseventnotes.domain.Constants.TYPE_FUN_EDIT
import com.bivizul.sportseventnotes.domain.model.CardItem
import com.bivizul.sportseventnotes.ui.navigation.Routes
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel
import com.vanpra.composematerialdialogs.MaterialDialog
import com.vanpra.composematerialdialogs.datetime.date.datepicker
import com.vanpra.composematerialdialogs.datetime.time.timepicker
import com.vanpra.composematerialdialogs.rememberMaterialDialogState

@Composable
fun CardInner(
    navController: NavController,
    viewModel: ListCardsViewModel,
    card: CardItem = CardItem(),
    typeFun: String,
    textTitle: String,
    textButton: String,
) {

    val colorRed = MaterialTheme.colors.error
    val colorFullButton = Color.Gray
    val scrollState = rememberScrollState()

    var nameEvent by remember { mutableStateOf(card.event) }
    var dateButton by remember { mutableStateOf(card.date) }
    var timeButton by remember { mutableStateOf(card.time) }
    var team1 by remember { mutableStateOf(card.team1) }
    var team2 by remember { mutableStateOf(card.team2) }
    var coefficient by remember { mutableStateOf(card.coefficient) }
    var incomeRisk by remember { mutableStateOf(card.incomeRisk) }

    var isButtonEnabled by remember { mutableStateOf(false) }
    var colorButtonDate by remember {
        mutableStateOf(when (dateButton) {
            TEXT_DATE_BUTTON -> colorRed
            else -> colorFullButton
        })
    }
    var colorButtonTime by remember {
        mutableStateOf(when (dateButton) {
            TEXT_DATE_BUTTON -> colorRed
            else -> colorFullButton
        })
    }

    val allIsNotEmpty = nameEvent.isNotEmpty()
            && dateButton != TEXT_DATE_BUTTON
            && timeButton != TEXT_TIME_BUTTON
            && team1.isNotEmpty()
            && team2.isNotEmpty()
            && coefficient.isNotEmpty()
            && incomeRisk.isNotEmpty()

    val dialogStateDate = rememberMaterialDialogState()
    val dialogStateTime = rememberMaterialDialogState()

    val cardAddEdit = CardItem(
        id = card.id,
        event = nameEvent,
        date = dateButton,
        time = timeButton,
        team1 = team1,
        team2 = team2,
        coefficient = coefficient,
        incomeRisk = incomeRisk
    )

    val onClick = when (typeFun) {
        TYPE_FUN_EDIT -> {
            {
                viewModel.editCardItem(cardItem = cardAddEdit)
                navController.navigate(Routes.LIST_CARD_ROUTE)
            }
        }
        else -> {
            {
                viewModel.addCardItem(cardItem = cardAddEdit)
                navController.navigate(Routes.LIST_CARD_ROUTE)
            }
        }
    }

    MaterialDialog(
        dialogState = dialogStateDate,
        buttons = {
            positiveButton(stringResource(R.string.ok))
            negativeButton(stringResource(R.string.cancel))
        }
    ) { datepicker { date -> dateButton = date.toString() } }

    MaterialDialog(
        dialogState = dialogStateTime,
        buttons = {
            positiveButton(stringResource(R.string.ok))
            negativeButton(stringResource(R.string.cancel))
        }
    ) { timepicker { time -> timeButton = time.toString() } }

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .verticalScroll(scrollState),
            verticalArrangement = Arrangement.SpaceAround,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                text = textTitle,
                style = MaterialTheme.typography.h4
            )

            OutlinedTextField(
                value = nameEvent,
                onValueChange = {
                    nameEvent = it
                    isButtonEnabled = allIsNotEmpty
                },
                label = { Text(text = stringResource(R.string.name_event)) },
                isError = nameEvent.isEmpty()
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Button(
                    onClick = {
                        dialogStateDate.show()
                        colorButtonDate = colorFullButton
                        isButtonEnabled = allIsNotEmpty
                    },
                    border = BorderStroke(1.dp, colorButtonDate),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(text = dateButton)
                }
                Button(
                    onClick = {
                        dialogStateTime.show()
                        colorButtonTime = colorFullButton
                        isButtonEnabled = allIsNotEmpty
                    },
                    border = BorderStroke(1.dp, colorButtonTime),
                    colors = ButtonDefaults.buttonColors(Color.Transparent),
                    elevation = ButtonDefaults.elevation(0.dp)
                ) {
                    Text(text = timeButton)
                }
            }

            OutlinedTextField(
                value = team1,
                onValueChange = {
                    team1 = it
                    isButtonEnabled = allIsNotEmpty
                },
                label = { Text(text = stringResource(R.string.team_1)) },
                isError = team1.isEmpty()
            )

            OutlinedTextField(
                value = team2,
                onValueChange = {
                    team2 = it
                    isButtonEnabled = allIsNotEmpty
                },
                label = { Text(text = stringResource(R.string.team_2)) },
                isError = team2.isEmpty()
            )

            OutlinedTextField(
                value = coefficient,
                onValueChange = {
                    coefficient = it
                    isButtonEnabled = allIsNotEmpty
                },
                label = { Text(text = stringResource(R.string.coefficient)) },
                isError = coefficient.isEmpty(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal)
            )

            OutlinedTextField(
                value = incomeRisk,
                onValueChange = {
                    incomeRisk = it
                    isButtonEnabled = allIsNotEmpty
                },
                label = { Text(text = stringResource(R.string.income_risk)) },
                isError = incomeRisk.isEmpty(),
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
            )

            Button(
                onClick = onClick,
                enabled = isButtonEnabled,
            ) {
                Text(text = textButton)
            }

        }
    }
}