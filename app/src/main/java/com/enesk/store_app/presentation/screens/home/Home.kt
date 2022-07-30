package com.enesk.store_app.presentation.screens.home

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.enesk.store_app.domain.model.product.ProductResponse
import com.enesk.store_app.domain.model.product.ProductResponseItem
import com.enesk.store_app.presentation.components.ApiErrorState
import com.enesk.store_app.presentation.components.ApiLoadingState
import com.enesk.store_app.presentation.navigation.Screens
import com.enesk.store_app.presentation.ui.theme.priceBackground
import com.enesk.store_app.utils.Constants.PRODUCT_DETAILS_ARGUMENT_KEY


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
    navController: NavController,
    homeData: ProductResponse,
    viewModel: HomeViewModel
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

@ExperimentalCoilApi
@Composable
fun ProductCard(
    navController: NavController,
    homeData: ProductResponseItem,
) {

    Surface(
        modifier = Modifier
            .fillMaxWidth()
            .wrapContentHeight()
    ) {

        Card(
            modifier = Modifier
                .padding(10.dp)
                .border(1.dp, Color.Black, RoundedCornerShape(15.dp))
                .height(150.dp)
                .clickable {
                    navController.currentBackStackEntry?.savedStateHandle?.set(
                        PRODUCT_DETAILS_ARGUMENT_KEY,
                        homeData
                    )
                    navController.navigate(Screens.ProductDetail.route)
                },
            elevation = 5.dp,
            shape = RoundedCornerShape(15.dp),

            ) {

            Row(
                modifier = Modifier.padding(horizontal = 10.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {

                Image(
                    painter = rememberImagePainter(data = homeData.image),
                    contentDescription = "image",
                    modifier = Modifier
                        .padding(10.dp)
                        .size(150.dp, 200.dp)
                        .clip(CircleShape)
                        .weight(0.3f),
                )

                Column(
                    modifier = Modifier
                        .weight(0.7f)
                        .fillMaxWidth()
                        .padding(horizontal = 25.dp),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {

                    Text(
                        modifier = Modifier.fillMaxWidth(),
                        text = homeData.title!!,
                        maxLines = 2,
                        overflow = TextOverflow.Ellipsis
                    )

                    Spacer(modifier = Modifier.padding(7.dp))
                    Text(
                        text = "${homeData.price} TL",
                        Modifier
                            .background(color = priceBackground, shape = RoundedCornerShape(10.dp))
                            .padding(8.dp),
                        color = Color.Black,
                        fontWeight = FontWeight.Bold
                    )
                }
            }

        }

    }
}