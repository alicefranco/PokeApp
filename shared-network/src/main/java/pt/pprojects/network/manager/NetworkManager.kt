package pt.pprojects.network.manager

import io.reactivex.Completable
import io.reactivex.Single
import io.reactivex.functions.Function
import pt.pprojects.network.ConnectionCheckInterface
import pt.pprojects.network.error.NetworkingError

class NetworkManager(
    private val connectionCheck: ConnectionCheckInterface,
    private val networkingErrorMapper: Function<Throwable, NetworkingError>
) : NetworkManagerInterface {

    override fun performAndDone(request: Completable): Completable {
        return when (connectionCheck.hasInternetConnection()) {
            false -> Completable.error(NetworkingError.NoInternetConnection)
            true -> request
                .onErrorResumeNext { cause ->
                    Completable.error(networkingErrorMapper.apply(cause))
                }
        }
    }

    override fun <Data> performAndReturnsData(request: Single<Data>): Single<Data> {
        return when (connectionCheck.hasInternetConnection()) {
            false -> Single.error(NetworkingError.NoInternetConnection)
            true -> request
                .onErrorResumeNext { cause -> Single.error(networkingErrorMapper.apply(cause)) }
        }
    }
}
