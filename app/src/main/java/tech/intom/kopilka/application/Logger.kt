package tech.intom.kopilka.application

import android.util.Log
import tech.intom.kopilka.BuildConfig

/**
 * Created by root on 06.04.18.
 */
object Logger {

    val LOG_TAG = "DEBUG DEVELOPMENT"

    fun log(message: String) {
        if (BuildConfig.DEBUG) {
            Log.d(LOG_TAG, message)
        }
    }
}