package tech.intom.kopilka.presentation.views.abstractions

import android.support.v4.app.FragmentManager
import android.support.v7.app.AppCompatActivity


/**
 * Created by root on 05.04.18.
 */
interface ParentFragmentScreen<ParentActivity : AppCompatActivity> : ParentScreen<ParentActivity> {

    fun getSupportFragmentManager(): FragmentManager
    fun getContainerId(): Int
}