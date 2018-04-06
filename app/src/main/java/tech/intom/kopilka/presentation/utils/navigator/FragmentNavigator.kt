package tech.intom.kopilka.presentation.utils.navigator

import android.os.Bundle
import android.support.v4.app.Fragment
import ru.terrakok.cicerone.android.SupportFragmentNavigator
import tech.intom.kopilka.application.Logger
import tech.intom.kopilka.presentation.views.abstractions.ParentFragmentScreen

/**
 * Created by root on 05.04.18.
 */
class FragmentNavigator(parentFragmentScreen: ParentFragmentScreen<*>) :
        SupportFragmentNavigator(
                parentFragmentScreen.getSupportFragmentManager(),
                parentFragmentScreen.getContainerId()) {

    private val mParentFragmentScreen: ParentFragmentScreen<*> = parentFragmentScreen

    override public fun exit() {
        mParentFragmentScreen.getParentActivity().finish()
    }

    override public fun createFragment(screenKey: String, data: Any?): Fragment {
        if (data != null && data is Bundle) {
            return FragmentFactory.createFragment(screenKey, data)
        } else {
            return FragmentFactory.createFragment(screenKey)
        }
    }

    override fun showSystemMessage(message: String) {
        Logger.log(message)
    }
}