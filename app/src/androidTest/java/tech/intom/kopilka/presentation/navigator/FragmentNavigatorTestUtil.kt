package tech.intom.kopilka.navigator

import tech.intom.kopilka.presentation.utils.navigator.FragmentFactory
import java.util.ArrayList

/**
 * Created by root on 06.04.18.
 */
object FragmentNavigatorTestUtil {

    fun testAllFragments(test: (String) -> Unit) {
        for (tag in getFragmentTags()) {
            test(tag)
        }
    }

    private fun getFragmentTags() : List<String> {
        val tags = ArrayList<String>()

        tags.add(FragmentFactory.MAIN_FRAGMENT_TAG)

        return tags
    }
}