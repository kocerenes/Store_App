package com.enesk.store_app.presentation.screens.home

import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import com.enesk.store_app.presentation.components.ProductCard

@ExperimentalCoilApi
@Composable
fun ProductListScreen(navController: NavController){
    ProductCard()
}