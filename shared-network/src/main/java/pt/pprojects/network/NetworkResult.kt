package pt.pprojects.network

import pt.pprojects.network.error.NetworkingError

sealed class NetworkResult<out T> {
    data class Error(val cause: NetworkingError) : NetworkResult<Nothing>()
    data class Success<T>(val data: T) : NetworkResult<T>()
}
