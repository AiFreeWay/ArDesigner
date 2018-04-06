package tech.intom.kopilka.presentation.utils.navigator

import android.os.Bundle
import android.support.v4.app.Fragment
import tech.intom.kopilka.application.Exceptions
import tech.intom.kopilka.presentation.views.fragment.MainFragment

/**
 * Created by root on 06.04.18.
 */
object FragmentFactory {

    val MAIN_FRAGMENT_TAG = MainFragment::class.java.canonicalName

    fun createFragment(tag: String): Fragment {
        return when(tag) {
            MAIN_FRAGMENT_TAG -> MainFragment()
            else -> throw Exception(Exceptions.INVALID_FRAGMENT_TAG_EXCEPTION)
        }
    }

    fun createFragment(tag: String, data: Bundle): Fragment {
        val fragment = createFragment(tag)
        fragment.arguments = data

        return fragment
    }
}