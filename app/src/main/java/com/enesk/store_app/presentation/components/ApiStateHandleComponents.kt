package com.enesk.store_app.presentation.components


import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.enesk.store_app.presentation.ui.theme.priceBackground


@Composable
fun ApiLoadingState(
    modifier: Modifier = Modifier,
    contentAlignment: Alignment = Alignment.Center,
    color: Color = Color.Black
){
    Column(
        modifier = modifier.fillMaxSize(),
        //contentAlignment = contentAlignment
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth(),
            color = Color.Blue
        )
    //CircularProgressIndicator(color = color)
    }

}

@Composable
fun ApiErrorState(message: String){
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
       Text(
           text = message,
           fontSize = 24.sp,
           textAlign = TextAlign.Center,
           color = Color.Black,
           fontWeight = FontWeight.Bold,
           modifier = Modifier
               .fillMaxWidth()
               .padding(horizontal = 30.dp)
       )
    }
}