package tech.intom.kopilka.navigator

import android.os.Bundle
import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.*
import org.junit.runner.RunWith
import tech.intom.kopilka.application.Exceptions
import tech.intom.kopilka.presentation.utils.navigator.FragmentFactory

/**
 * Created by root on 06.04.18.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class FragmentFactoryTest {

    val INVALID_FRAGMENT_TAG = "bla bla bla"

    @Test
    fun testCreateFragment() {
        FragmentNavigatorTestUtil.testAllFragments({
            val fragment = FragmentFactory.createFragment(it)
            Assert.assertEquals(fragment::class.java.canonicalName, it)
        })
    }

    @Test
    fun testCreateFragmentBundle() {
        val testBundle = Bundle()
        FragmentNavigatorTestUtil.testAllFragments({
            val fragment = FragmentFactory.createFragment(it, testBundle)
            Assert.assertEquals(fragment::class.java.canonicalName, it)
            Assert.assertNotNull(fragment.arguments)
        })
    }

    @Test
    fun testErrorCreateFragment() {
        try {
            FragmentFactory.createFragment(INVALID_FRAGMENT_TAG)
        } catch (e: Exception ) {
            Assert.assertEquals(e.message, Exceptions.INVALID_FRAGMENT_TAG_EXCEPTION)
        }
    }
}