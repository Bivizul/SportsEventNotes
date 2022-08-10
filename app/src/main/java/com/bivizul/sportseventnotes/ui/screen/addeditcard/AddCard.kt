package com.bivizul.sportseventnotes.ui.screen.addeditcard

import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.R
import com.bivizul.sportseventnotes.domain.Constants.TYPE_FUN_ADD
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel

@Composable
fun AddCard(
    navController: NavController,
    viewModel: ListCardsViewModel,
) {

    val textTitle = stringResource(R.string.add_card)
    val textButton = stringResource(R.string.add_new_card)

    CardInner(
        navController = navController,
        viewModel = viewModel,
        typeFun = TYPE_FUN_ADD,
        textTitle = textTitle,
        textButton = textButton
    )
}




