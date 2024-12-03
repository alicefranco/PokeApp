package pt.pprojects.pokeapp.network

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import androidx.core.content.ContextCompat
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import pt.pprojects.network.ConnectionCheckInterface

class ConnectionCheck @Inject constructor(
    @ApplicationContext context: Context
) : ConnectionCheckInterface {

    private val connectivityService = ContextCompat.getSystemService(context, ConnectivityManager::class.java)

    override fun hasInternetConnection(): Boolean {
        val network = connectivityService?.activeNetwork ?: return false
        val capabilities = connectivityService.getNetworkCapabilities(network) ?: return false
        return capabilities.run {
            hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) ||
            hasTransport(NetworkCapabilities.TRANSPORT_WIFI)
        }
    }
}