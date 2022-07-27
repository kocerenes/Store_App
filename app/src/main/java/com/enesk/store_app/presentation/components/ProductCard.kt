package com.enesk.store_app.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import coil.annotation.ExperimentalCoilApi
import coil.compose.rememberImagePainter

@ExperimentalCoilApi
@Composable
fun ProductCard(){
    Surface(modifier = Modifier
        .fillMaxWidth()
        .wrapContentHeight()
    ) {
        
        Card(
            modifier = Modifier.border(1.dp, Color.Black, RoundedCornerShape(15.dp)).height(150.dp),
            elevation = 5.dp,
            shape = RoundedCornerShape(5.dp)
        ) {
            
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround
            ) {
                Text(text = "Image")

                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(text = "Description")
                    Text(text = "20 TL",Modifier.background(Color.Blue))
                }
            }
            
        }
        
    }
}