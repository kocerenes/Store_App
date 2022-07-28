package com.enesk.store_app.presentation.screens.home

import com.enesk.store_app.domain.model.product.ProductResponse

data class HomeState(
    val isLoading: Boolean = false,
    val homeData: ProductResponse? = null,
    val error: Int = 0,
)