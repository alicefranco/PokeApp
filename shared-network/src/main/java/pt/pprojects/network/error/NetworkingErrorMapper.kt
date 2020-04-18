package pt.pprojects.network.error

import io.reactivex.functions.Function
import kotlinx.serialization.SerializationException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

class NetworkingErrorMapper : Function<Throwable, NetworkingError> {
    override fun apply(cause: Throwable): NetworkingError {
        return when (cause) {
            is SerializationException -> NetworkingError.InvalidDataFormat
            is SocketTimeoutException -> NetworkingError.ConnectionTimeout
            is UnknownHostException -> NetworkingError.UnknownEndpoint(cause)
            else -> NetworkingError.UnknownNetworkException(cause)
        }
    }
}
