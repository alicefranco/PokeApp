package pt.pprojects.network.manager

import javax.inject.Inject
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import pt.pprojects.network.ConnectionCheckInterface
import pt.pprojects.network.NetworkResult
import pt.pprojects.network.error.NetworkingError
import pt.pprojects.network.error.NetworkingErrorMapper

class NetworkManager @Inject constructor(
    private val connectionCheck: ConnectionCheckInterface,
    private val networkingErrorMapper: NetworkingErrorMapper
) : NetworkManagerInterface {

    override suspend fun <Data : Any> performAndReturnsData(data: Data): Flow<NetworkResult<Data>> {
        return when (connectionCheck.hasInternetConnection()) {
            false -> flow { emit(NetworkResult.Error(NetworkingError.NoInternetConnection)) }
            true ->  flow {
                try {
                    emit(NetworkResult.Success(data))
                } catch (e: Exception) {
                    e.cause?.let {
                        emit(NetworkResult.Error(networkingErrorMapper.mapThrowableToNetworkingError(it)))
                    }
                }
            }.flowOn(Dispatchers.IO)
        }
    }
}
