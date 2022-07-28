package com.enesk.store_app.data.repository

import com.enesk.store_app.data.remote.ApiFactory
import com.enesk.store_app.domain.repository.ProductRepository
import com.enesk.store_app.domain.model.product.ProductResponse
import javax.inject.Inject

class ProductRepository @Inject constructor(
    private val apiFactory: ApiFactory
): ProductRepository {
    override suspend fun getAllProduct(): ProductResponse {
        return apiFactory.getAllProducts().body()!!
    }
}