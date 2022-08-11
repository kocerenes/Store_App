package com.enesk.store_app.presentation.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.enesk.store_app.domain.model.product.ProductResponse
import com.enesk.store_app.presentation.components.ApiErrorState
import com.enesk.store_app.presentation.components.ApiLoadingState


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Home(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
) {
    val productListState = viewModel.homeState.value
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        if (productListState.isLoading) {
            ApiLoadingState()
        }
        if (productListState.error != 0) {
            val message = context.getString(productListState.error)
            ApiErrorState(message = message)
        }
        if (productListState.homeData != null) {
            ProductListScreen(
                navController = navController,
                homeData = productListState.homeData
            )
        }
    }
}

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ProductListScreen(
    navController: NavController,
    homeData: ProductResponse
) {

    Column() {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .height(1000.dp)
        ) {
            items(homeData) { item ->
                ProductCard(
                    navController,
                    item
                )
            }
        }
    }
}
