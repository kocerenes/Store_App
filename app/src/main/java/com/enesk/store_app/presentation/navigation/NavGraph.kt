package com.enesk.store_app.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHost
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.enesk.store_app.presentation.screens.home.ProductListScreen

@ExperimentalCoilApi
@Composable
fun SetupNavigation(){
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "product_list_screen"
    ){
        composable("product_list_screen"){
            ProductListScreen(navController = navController)
        }
    }
}