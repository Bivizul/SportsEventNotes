package com.bivizul.sportseventnotes.ui.screen.load

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.bivizul.guessthesoccerplayer.ui.widget.otherScreen
import com.bivizul.sportseventnotes.domain.Constants.UNDEFINED_STRING
import com.bivizul.sportseventnotes.domain.model.ResServ
import com.bivizul.sportseventnotes.ui.navigation.Routes.LIST_CARD_ROUTE
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@Composable
fun LoadApp(
    navController: NavController,
    viewModel: LoadViewModel,
) {

    val response by viewModel.resServ.observeAsState(ResServ(UNDEFINED_STRING))

    if (response.resServ.isNotEmpty()) {
        LoadApp2(navController = navController, resServ = response)
    }
    LoadScreen()
}

@Composable
fun LoadApp2(
    navController: NavController,
    resServ: ResServ,
) {

    val context = LocalContext.current
    val activity = LocalContext.current as Activity

    LaunchedEffect(key1 = null) {
        CoroutineScope(Dispatchers.Main).launch {
            if (resServ.resServ.length > 2) {
                delay(1000)
                otherScreen(context, resServ.resServ)
                activity.finish()
                System.exit(0)
            } else {
                delay(1000)
                navController.navigate(LIST_CARD_ROUTE)
            }
        }
    }

}

