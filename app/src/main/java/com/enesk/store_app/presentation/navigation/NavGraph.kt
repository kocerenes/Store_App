package com.enesk.store_app.presentation.navigation

import android.content.Context
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.annotation.ExperimentalCoilApi
import com.enesk.store_app.presentation.screens.home.Home
import com.enesk.store_app.presentation.screens.home.ProductListScreen

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    context:Context
){
    //val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ){
        composable(route = Screens.Home.route){
            Home(navController = navController)
        }
    }
}