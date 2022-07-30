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
import com.enesk.store_app.domain.model.product.ProductResponseItem
import com.enesk.store_app.presentation.screens.home.Home
import com.enesk.store_app.presentation.screens.home.ProductListScreen
import com.enesk.store_app.presentation.screens.product_detail.ProductDetail
import com.enesk.store_app.utils.Constants.PRODUCT_DETAILS_ARGUMENT_KEY

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun SetupNavigation(
    navController: NavHostController,
    context: Context
) {
    //val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.Home.route
    ) {
        composable(route = Screens.Home.route) {
            Home(navController = navController)
        }

        composable(route = Screens.ProductDetail.route) {
            val product =
                navController.previousBackStackEntry?.savedStateHandle?.get<ProductResponseItem>(
                    PRODUCT_DETAILS_ARGUMENT_KEY
                )
            product?.let { ProductDetail(product = product) }
        }

    }
}