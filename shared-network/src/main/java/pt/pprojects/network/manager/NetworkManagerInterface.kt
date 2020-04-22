package pt.pprojects.network.manager

import io.reactivex.Completable
import io.reactivex.Single

interface NetworkManagerInterface {
    fun performAndDone(request: Completable): Completable
    fun <Data> performAndReturnsData(request: Single<Data>): Single<Data>
}
