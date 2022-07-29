package com.enesk.store_app.presentation.screens.home

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import com.enesk.store_app.domain.model.product.ProductResponse



@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun Home(
    navController: NavHostController,
    viewModel: HomeViewModel = hiltViewModel()
){
    val productListState = viewModel.homeState.value
    val context = LocalContext.current

    Surface(
        modifier = Modifier.fillMaxSize()
    ) {

        if (productListState.isLoading){
            //ApiLoadingState()
        }
        if (productListState.error !=0){
            val message = context.getString(productListState.error)
            //ApiErrorState(message = message)
        }

        if (productListState.homeData != null){
            ProductListScreen(
                homeData = productListState.homeData,
                viewModel = viewModel
            )
        }

    }

}


@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ProductListScreen(
    homeData : ProductResponse,
    viewModel: HomeViewModel
){


    Column() {
        LazyColumn(
            modifier = Modifier
                .padding(bottom = 10.dp)
                .height(1000.dp)
        ){
            items(homeData) {item ->
                ProductCard(
                    item.image!!,
                    item.title!!,
                    item.price!!
                )
            }
        }
    }


}

@ExperimentalCoilApi
@Composable
fun ProductCard(
    image : String,
    title : String,
    price : String
){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {

        Card(
            modifier = Modifier
                .padding(10.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(15.dp))
                .height(150.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp)
        ) {

            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "image")

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = title)
                    Text(text = price,Modifier.background(Color.Blue), color = Color.White)
                }
            }

        }

    }
}