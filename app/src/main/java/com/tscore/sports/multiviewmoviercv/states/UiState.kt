package com.tscore.sports.multiviewmoviercv.states

sealed class UiState<T>(
    val data: T? = null,
    val message: String? = null,
    var hasNetworkError: Boolean? = false
) {
    class Loading<T> : UiState<T>()
    class Error<T>(message: String?, isNetworkError: Boolean) :
        UiState<T>(message = message, hasNetworkError = isNetworkError)

    class Success<T>(data: T?) : UiState<T>(data = data)
}

