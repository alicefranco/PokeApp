package pt.pprojects.network.manager

import kotlinx.coroutines.flow.Flow
import pt.pprojects.network.NetworkResult

interface NetworkManagerInterface {
    suspend fun <Data : Any> performAndReturnsData(data: Data): Flow<NetworkResult<Data>>
}
