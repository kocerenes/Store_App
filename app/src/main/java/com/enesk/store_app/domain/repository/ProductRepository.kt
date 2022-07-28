package com.enesk.store_app.domain.repository

import com.enesk.store_app.domain.model.product.ProductResponse

interface ProductRepository {

    suspend fun getAllProduct() : ProductResponse

}