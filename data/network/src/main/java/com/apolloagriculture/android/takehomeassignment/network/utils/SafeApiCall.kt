package com.apolloagriculture.android.takehomeassignment.network.utils

import com.apolloagriculture.android.takehomeassignment.domain.utils.Result
import io.ktor.client.features.ClientRequestException
import io.ktor.client.features.RedirectResponseException
import io.ktor.client.features.ServerResponseException

suspend fun <T : Any> safeApiCall(apiCall: suspend () -> T): Result<T> {
    return try {
        Result.Success(data = apiCall.invoke())
    } catch (e: RedirectResponseException) { // 3xx errors
        Result.Error(
            errorCode = e.response.status.value,
            errorMessage = e.localizedMessage
        )
    } catch (e: ClientRequestException) { // 4xx errors
        Result.Error(
            errorCode = e.response.status.value,
            errorMessage = e.localizedMessage
        )
    } catch (e: ServerResponseException) { // 5xx errors
        Result.Error(
            errorCode = e.response.status.value,
            errorMessage = e.localizedMessage
        )
    } catch (e: Exception) {
        Result.Error(
            errorCode = 0,
            errorMessage = e.localizedMessage ?: "An unknown error occurred"
        )
    }
}
