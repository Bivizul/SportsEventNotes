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
import com.bivizul.sportseventnotes.domain.Resource
import com.bivizul.sportseventnotes.domain.Utils
import com.bivizul.sportseventnotes.domain.model.ResServ
import com.bivizul.sportseventnotes.ui.navigation.Routes.MAIN_ROUTE
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

                        Log.e("qwer","resource : ${it.resServ}")

                        if (it.resServ.length > 2) {
                            delay(1000)
                            navController.navigate(MAIN_ROUTE)

//                            val intent = Intent(activity, WebActivity::class.java)
//                            intent.putExtra(KEY_OUT_RESPONSE, it.posil)
//                            startActivity(context, intent, bundleOf())
                        } else {
                            delay(1000)
                            navController.navigate(MAIN_ROUTE)
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

@Composable
fun LoadScreen(

) {
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        backgroundColor = MaterialTheme.colors.background,
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator(
                modifier = Modifier.size(50.dp),
                color = MaterialTheme.colors.onPrimary
            )
        }
    }
}