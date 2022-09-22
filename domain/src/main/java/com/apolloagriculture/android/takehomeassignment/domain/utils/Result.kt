package com.apolloagriculture.android.takehomeassignment.domain.utils

sealed class Result<T>(
    val data: T? = null,
    val error: Exception? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(error: Exception, errorMessage: String?) :
        Result<T>(error = error, errorMessage = errorMessage)
}
