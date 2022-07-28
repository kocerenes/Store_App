package com.enesk.store_app.data.remote

import com.enesk.store_app.domain.model.product.ProductResponse
import retrofit2.Response
import retrofit2.http.GET

interface ApiFactory {

    @GET("products")
    suspend fun getAllProducts() : Response<ProductResponse>

}