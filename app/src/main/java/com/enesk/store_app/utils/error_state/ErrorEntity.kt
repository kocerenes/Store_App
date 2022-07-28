package com.enesk.store_app.utils.error_state

import com.enesk.store_app.R

enum class ErrorEntity(val errorDescription : Int){
    NETWORK_ERROR(R.string.error_handle_network),
    NOT_FOUND_ERROR(R.string.error_handle_not_found),
    ACCESS_DENIED_ERROR(R.string.error_handle_access_denied),
    SERVICE_UNAVAILABLE_ERROR(R.string.error_handle_service_unavailable),
    UNKNOWN_ERROR(R.string.error_handle_unknown);

    companion object{
        fun getErrorType(type: Int): ErrorEntity{
            return when(type){
                403 -> {
                    ACCESS_DENIED_ERROR
                }
                404 -> {
                    NOT_FOUND_ERROR
                }
                503 ->{
                    SERVICE_UNAVAILABLE_ERROR
                }
                else -> {
                    UNKNOWN_ERROR
                }
            }
        }
    }

}