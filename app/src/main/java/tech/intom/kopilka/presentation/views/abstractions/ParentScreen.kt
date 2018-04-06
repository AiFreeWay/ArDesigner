package tech.intom.kopilka.presentation.views.abstractions

import android.support.v7.app.AppCompatActivity


/**
 * Created by root on 04.04.18.
 */
interface ParentScreen<ParentActivity: AppCompatActivity> {

    fun getParentActivity(): ParentActivity
}