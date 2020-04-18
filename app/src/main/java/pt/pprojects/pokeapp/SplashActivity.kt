package pt.pprojects.pokeapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import pt.pprojects.pokelist.presentation.pokelist.PokeListActivity

class SplashActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Handler().postDelayed({
            startActivity(Intent(this, PokeListActivity::class.java))
            finish()
        }, DELAY_SIMULATION)
    }

    private companion object {
        private const val DELAY_SIMULATION = 1000L
    }
}
