package com.bivizul.sportseventnotes.ui.navigation

import android.app.Activity
import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bivizul.sportseventnotes.domain.Constants.ID
import com.bivizul.sportseventnotes.domain.Constants.ID_DEF
import com.bivizul.sportseventnotes.ui.navigation.Routes.ADD_ROUTE
import com.bivizul.sportseventnotes.ui.navigation.Routes.EDIT_ROUTE
import com.bivizul.sportseventnotes.ui.navigation.Routes.LIST_CARD_ROUTE
import com.bivizul.sportseventnotes.ui.navigation.Routes.LOAD_ROUTE
import com.bivizul.sportseventnotes.ui.screen.addeditcard.AddCard
import com.bivizul.sportseventnotes.ui.screen.detailcard.EditCard
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCards
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel
import com.bivizul.sportseventnotes.ui.screen.load.LoadApp
import com.bivizul.sportseventnotes.ui.screen.load.LoadViewModel

object Routes {
    const val LIST_CARD_ROUTE = "list_card_route"
    const val LOAD_ROUTE = "load_route"
    const val EDIT_ROUTE = "edit_route"
    const val ADD_ROUTE = "add_route"
}

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = LOAD_ROUTE,
    loadViewModel: LoadViewModel,
    listCardsViewModel: ListCardsViewModel = hiltViewModel(),
) {

    val activity = LocalContext.current as Activity

    NavHost(navController = navHostController, startDestination = startDestination) {

        composable(route = startDestination) {
            LoadApp(
                navController = navHostController,
                viewModel = loadViewModel
            )
            BackHandler() {
                activity.finishAndRemoveTask()
                System.exit(0)
            }
        }

        composable(route = LIST_CARD_ROUTE) {
            ListCards(
                navController = navHostController,
                viewModel = listCardsViewModel
            )
            BackHandler() {
                activity.finishAndRemoveTask()
                System.exit(0)
            }
        }

        composable(route = EDIT_ROUTE + "/{${ID}}") { backStackEntry ->
            EditCard(
                navController = navHostController,
                viewModel = listCardsViewModel,
                cardId = backStackEntry.arguments?.getString(ID) ?: ID_DEF
            )
        }

        composable(route = ADD_ROUTE) {
            AddCard(
                navController = navHostController,
                viewModel = listCardsViewModel
            )
        }

    }

}