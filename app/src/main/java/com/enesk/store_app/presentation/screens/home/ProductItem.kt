package com.enesk.store_app.presentation.screens.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.enesk.store_app.domain.model.product.ProductResponseItem
import com.enesk.store_app.presentation.navigation.Screens
import com.enesk.store_app.presentation.ui.theme.priceBackground
import com.enesk.store_app.utils.Constants

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
                        Constants.PRODUCT_DETAILS_ARGUMENT_KEY,
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