package com.enesk.store_app.domain.use_cases.get_home_data

import com.enesk.store_app.data.repository.ProductRepositoryImpl
import com.enesk.store_app.domain.model.product.ProductResponse
import com.enesk.store_app.utils.Resource
import com.enesk.store_app.utils.error_state.ErrorEntity
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class GetHomeDataUseCase @Inject constructor(
    private val repository: ProductRepositoryImpl
) {
    operator fun invoke(): Flow<Resource<ProductResponse>> = flow {
        try {
            emit(Resource.Loading())
            val productList = repository.getAllProduct()
            emit(Resource.Success(productList))
        } catch (e: HttpException) {
            emit(Resource.Error(ErrorEntity.getErrorType(e.code())))
        } catch (e: IOException) {
            emit(Resource.Error(ErrorEntity.NETWORK_ERROR))
        }
    }
}