package tech.intom.kopilka.presentation.views.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import tech.intom.kopilka.presentation.utils.navigator.ActivityNavigator
import tech.intom.kopilka.presentation.views.abstractions.SpashScreen

class SplashActivity : AppCompatActivity(), SpashScreen {

    private val mSplashHandler = Handler()

    private val mToMainRunnable = Runnable {
        showMainScreen()
    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)

        startToMainRunnable(SPLASH_SCREEN_DELAY)
    }

    override fun showMainScreen() {
        ActivityNavigator.showMainScreen(this)
        finish()
    }

    private fun startToMainRunnable(delayMillis: Int) {
        mSplashHandler.removeCallbacks(mToMainRunnable)
        mSplashHandler.postDelayed(mToMainRunnable, delayMillis.toLong())
    }

    companion object {

        private val SPLASH_SCREEN_DELAY = 1900
    }
}
