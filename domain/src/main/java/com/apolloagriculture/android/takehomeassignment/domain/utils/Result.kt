package com.apolloagriculture.android.takehomeassignment.domain.utils

sealed class Result<T>(
    val data: T? = null,
    val errorCode: Int? = null,
    val errorMessage: String? = null
) {
    class Success<T>(data: T) : Result<T>(data)
    class Error<T>(errorCode: Int, errorMessage: String?) :
        Result<T>(errorCode = errorCode, errorMessage = errorMessage)
}
