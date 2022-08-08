package com.bivizul.sportseventnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import com.bivizul.sportseventnotes.domain.Utils
import com.bivizul.sportseventnotes.domain.model.LP
import com.bivizul.sportseventnotes.ui.navigation.NavGraph
import com.bivizul.sportseventnotes.ui.screen.load.LoadViewModel
import com.bivizul.sportseventnotes.ui.theme.SportsEventNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsEventNotesTheme {

                val loadViewModel = hiltViewModel<LoadViewModel>()

                if (Utils.checkNet(this)) {
                    try {
                        loadViewModel.getResServ(LP(Utils.getRespServ(this)))
                    } catch (e: Exception) {
                        Utils.getDialogErrorConnect(this, this)
                    }
                    NavGraph(
                        loadViewModel = loadViewModel,
                    )
                } else {
                    Utils.getDialogErrorConnect(this, this)
                }

                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    NavGraph(
                        loadViewModel = loadViewModel
                    )
                }
            }
        }
    }
}
