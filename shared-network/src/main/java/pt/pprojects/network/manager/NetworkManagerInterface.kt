package pt.pprojects.network.manager

import kotlinx.coroutines.flow.Flow
import pt.pprojects.network.NetworkResult

interface NetworkManagerInterface {
    fun <Data : Any> performAndReturnsData(request: Flow<Data>): Flow<NetworkResult<Data>>
}
