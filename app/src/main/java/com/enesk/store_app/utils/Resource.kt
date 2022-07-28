package com.enesk.store_app.utils

import com.enesk.store_app.utils.error_state.ErrorEntity

sealed class Resource<T>(val data: T? = null, val message: String? = null) {
    class Success<T>(data: T) : Resource<T>(data)
    class Error<T>(val error: ErrorEntity) : Resource<T>()
    class Loading<T>(data: T? = null) : Resource<T>(data)
}