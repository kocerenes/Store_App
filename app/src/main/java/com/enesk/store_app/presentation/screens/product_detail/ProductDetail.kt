package com.enesk.store_app.presentation.screens.product_detail

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter
import com.enesk.store_app.domain.model.product.ProductResponseItem
import com.enesk.store_app.presentation.ui.theme.priceBackground

@ExperimentalCoilApi
@ExperimentalFoundationApi
@Composable
fun ProductDetail(
    product: ProductResponseItem,
) {
    Surface(
        modifier = Modifier.fillMaxSize()
    ) {
        Column(
            verticalArrangement = Arrangement.SpaceEvenly,
            horizontalAlignment = Alignment.CenterHorizontally,
            modifier = Modifier
                .fillMaxSize()
        ) {
            Image(
                painter = rememberImagePainter(data = product.image),
                contentDescription = product.title,
            )

            Divider(color = priceBackground, thickness = 4.dp)

            Text(
                text = product.title!!,
                modifier = Modifier.padding(horizontal = 15.dp)
            )

            Text(
                text = product.description!!,
                modifier = Modifier.padding(horizontal = 20.dp)
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(
                    text = "${product.price} TL",
                    modifier = Modifier
                        .background(color = priceBackground, shape = RoundedCornerShape(10.dp))
                        .padding(8.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold,
                )

                Text(
                    text = "${product.category}",
                    modifier = Modifier
                        .background(color = priceBackground, shape = RoundedCornerShape(10.dp))
                        .padding(8.dp),
                    color = Color.Black,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}