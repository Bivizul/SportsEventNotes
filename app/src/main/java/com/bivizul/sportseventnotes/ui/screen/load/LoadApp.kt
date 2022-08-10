package com.bivizul.sportseventnotes.ui.screen.load

import android.app.Activity
import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.bivizul.guessthesoccerplayer.ui.widget.otherScreen
import com.bivizul.sportseventnotes.domain.Resource
import com.bivizul.sportseventnotes.domain.Utils
import com.bivizul.sportseventnotes.domain.model.LP
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
    val context = LocalContext.current
    val activity = LocalContext.current as Activity
    val resource by viewModel.resServ.observeAsState(Resource.Success(ResServ("")))

    LaunchedEffect(key1 = null) {
        CoroutineScope(Dispatchers.Main).launch {
            when (resource) {
                is Resource.Loading -> {}
                is Resource.Success -> {
                    resource.data?.let {
                        if (it.resServ.length > 2) {
                            delay(1000)
                            otherScreen(context,it.resServ)
                            activity.finish()
                            System.exit(0)
                        } else {
                            delay(1000)
                            navController.navigate(LIST_CARD_ROUTE)
                        }
                    }
                }
                is Resource.Error -> {
                    Utils.getDialogErrorConnect(context, activity)
                }
            }
        }
    }
    LoadScreen()
}

