package com.tscore.sports.multiviewmoviercv.base

import com.tscore.sports.multiviewmoviercv.states.UiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException

abstract class BaseRepo {

    suspend fun <E> safeApiCall(
        apiCall: suspend () -> E
    ): UiState<E> {

        return withContext(Dispatchers.IO) {
            try {
                UiState.Success(apiCall.invoke())
            } catch (tr: Throwable) {
                when (tr) {
                    is HttpException -> UiState.Error(
                        message = " ${tr.message}, code:${tr.code()}",
                        isNetworkError = true
                    )

                    else -> {
                        UiState.Error("${tr.message}", isNetworkError = false)
                    }
                }


            }
        }

    }

}

