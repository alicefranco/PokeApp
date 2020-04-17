package pt.pprojects.pokeapp

import android.app.Application

class PokeApp : Application() {
    override fun onCreate() {
        super.onCreate()

        initModules()
    }

    private fun initModules() {}
}