package com.enesk.store_app.presentation.navigation

sealed class Screens(
    val route : String,
    val title : Int?
) {

    object Home : Screens(
        "product_list_screen",
        null
    )

}