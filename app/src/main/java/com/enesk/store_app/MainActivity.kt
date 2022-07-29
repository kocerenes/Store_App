package com.enesk.store_app

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.enesk.store_app.presentation.navigation.SetupNavigation
import com.enesk.store_app.presentation.ui.theme.Store_AppTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalCoilApi
@ExperimentalFoundationApi
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Store_AppTheme {
                val navController = rememberNavController()
                val context = LocalContext.current
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    SetupNavigation(navController = navController, context = context)
                }
            }
        }
    }
}



