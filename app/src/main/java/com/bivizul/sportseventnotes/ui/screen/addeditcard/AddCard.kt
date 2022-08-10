package com.bivizul.sportseventnotes.ui.screen.addeditcard

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.bivizul.sportseventnotes.domain.Constants.TYPE_FUN_ADD
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel

@Composable
fun AddCard(
    navController: NavController,
    viewModel: ListCardsViewModel,
) {

    Log.e("qwer","AddCardScreen")

    val textTitle = "Add card"
    val textButton = "Add new card"

//    Scaffold(
//        modifier = Modifier.fillMaxSize(),
//        backgroundColor = MaterialTheme.colors.background,
//    ) { paddingValues ->
//        Column(
//            modifier = Modifier
//                .fillMaxSize()
//                .padding(paddingValues),
////            verticalArrangement = Arrangement.SpaceAround,
//            horizontalAlignment = Alignment.CenterHorizontally
//        ) {
//            Text(text = "Add card")
            CardInner(
                navController = navController,
                viewModel = viewModel,
                typeFun = TYPE_FUN_ADD,
                textTitle = textTitle,
                textButton = textButton
            )
//        }
//    }

}




