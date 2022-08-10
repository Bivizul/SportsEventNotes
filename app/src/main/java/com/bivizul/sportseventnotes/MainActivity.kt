package com.bivizul.sportseventnotes

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import com.bivizul.sportseventnotes.domain.Utils
import com.bivizul.sportseventnotes.ui.navigation.NavGraph
import com.bivizul.sportseventnotes.ui.theme.SportsEventNotesTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SportsEventNotesTheme {

                if (Utils.checkNet(this)) {
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colors.background
                    ) {
                        NavGraph()
                    }
                } else {
                    Utils.getDialogError(this, this)
                }
            }
        }
    }
}
