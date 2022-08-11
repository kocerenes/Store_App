package com.enesk.store_app.data.repository

import com.enesk.store_app.data.local.ProductDatabase
import com.enesk.store_app.data.remote.ApiFactory
import com.enesk.store_app.domain.repository.ProductRepository
import com.enesk.store_app.domain.model.product.ProductResponse
import com.enesk.store_app.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.io.IOException
import javax.inject.Inject

class ProductRepositoryImpl @Inject constructor(
    private val api: ApiFactory
): ProductRepository {

    override suspend fun getAllProduct(): ProductResponse {
        return api.getAllProducts().body()!!
    }
}