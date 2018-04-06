package tech.intom.kopilka.presentation.views.activities

import android.support.v7.app.AppCompatActivity
import tech.intom.kopilka.presentation.views.abstractions.MainScreen

/**
 * Created by root on 04.04.18.
 */
class AcMain : AppCompatActivity(), MainScreen {

    override fun getContainerId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getParentActivity() = this

    override fun onBackPressed() {
        super.onBackPressed()
        finish()
    }
}