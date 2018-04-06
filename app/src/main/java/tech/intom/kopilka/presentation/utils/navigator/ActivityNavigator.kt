package tech.intom.kopilka.presentation.utils.navigator

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import tech.intom.kopilka.presentation.views.activities.AcMain

/**
 * Created by root on 04.04.18.
 */
object ActivityNavigator {

    fun showMainScreen(activity: AppCompatActivity) {
        activity.startActivity(Intent(activity, AcMain::class.java))
    }
}