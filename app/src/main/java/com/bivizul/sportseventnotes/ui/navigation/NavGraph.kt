package com.bivizul.sportseventnotes.ui.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.bivizul.sportseventnotes.domain.Constants.ID
import com.bivizul.sportseventnotes.domain.Constants.ID_DEF
import com.bivizul.sportseventnotes.ui.navigation.Routes.ADD_ROUTE
import com.bivizul.sportseventnotes.ui.navigation.Routes.DETAIL_ROUTE
import com.bivizul.sportseventnotes.ui.navigation.Routes.LOAD_ROUTE
import com.bivizul.sportseventnotes.ui.navigation.Routes.MAIN_ROUTE
import com.bivizul.sportseventnotes.ui.screen.addcard.AddCard
import com.bivizul.sportseventnotes.ui.screen.detailcard.DetailCard
import com.bivizul.sportseventnotes.ui.screen.load.LoadApp
import com.bivizul.sportseventnotes.ui.screen.load.LoadViewModel
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCards
import com.bivizul.sportseventnotes.ui.screen.listcards.ListCardsViewModel

object Routes {
    const val MAIN_ROUTE = "main_route"
    const val LOAD_ROUTE = "load_route"
    const val DETAIL_ROUTE = "detail_route"
    const val ADD_ROUTE = "add_route"
}

@Composable
fun NavGraph(
    navHostController: NavHostController = rememberNavController(),
    startDestination: String = LOAD_ROUTE,
    loadViewModel: LoadViewModel,
    listCardsViewModel: ListCardsViewModel = hiltViewModel(),
) {

    NavHost(navController = navHostController, startDestination = startDestination) {

        composable(route = startDestination) {
            LoadApp(
                navController = navHostController,
                viewModel = loadViewModel
            )
        }

        composable(route = MAIN_ROUTE) {
            ListCards(
                navController = navHostController,
                viewModel = listCardsViewModel
            )
        }

        composable(route = DETAIL_ROUTE + "/{${ID}}") { backStackEntry ->
            DetailCard(
                navController = navHostController,
                viewModel = listCardsViewModel,
                cardId = backStackEntry.arguments?.getString(ID) ?: ID_DEF
            )
        }

        composable(route = ADD_ROUTE) {
            AddCard()
        }

    }

}