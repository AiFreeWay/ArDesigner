package tech.intom.kopilka.navigator

import android.os.Bundle
import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import tech.intom.kopilka.application.Exceptions
import tech.intom.kopilka.presentation.utils.navigator.FragmentNavigator
import tech.intom.kopilka.presentation.views.activities.AcMain
import tech.intom.kopilka.presentation.views.abstractions.ParentFragmentScreen

/**
 * Created by root on 06.04.18.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class FragmentNavigatorTest {

    val MOCK_CONTAINER_ID = 1
    val INVALID_FRAGMENT_TAG = "bla bla bla"

    @get:Rule
    val activityRule = ActivityTestRule<AcMain>(AcMain::class.java)

    lateinit var mFragmentNavigator: FragmentNavigator

    @Before
    fun init() {
        val parentScreen = object : ParentFragmentScreen<AcMain> {

            override fun getSupportFragmentManager() = activityRule.activity.supportFragmentManager

            override fun getContainerId() = MOCK_CONTAINER_ID

            override fun getParentActivity() = activityRule.activity
        }

        mFragmentNavigator = FragmentNavigator(parentScreen)
    }

    @Test
    fun testExit() {
        mFragmentNavigator.exit()
        Assert.assertEquals(activityRule.activity.isFinishing, true)
    }

    @Test
    fun testCreateFragment() {
        FragmentNavigatorTestUtil.testAllFragments({
            val fragment = mFragmentNavigator.createFragment(it, null)
            Assert.assertEquals(fragment::class.java.canonicalName, it)
        })
    }

    @Test
    fun testCreateFragmentBundle() {
        val testBundle = Bundle()
        FragmentNavigatorTestUtil.testAllFragments({
            val fragment = mFragmentNavigator.createFragment(it, testBundle)
            Assert.assertEquals(fragment::class.java.canonicalName, it)
            Assert.assertNotNull(fragment.arguments)
        })
    }

    @Test
    fun testErrorCreateFragment() {
        try {
            mFragmentNavigator.createFragment(INVALID_FRAGMENT_TAG, null)
        } catch (e: Exception ) {
            Assert.assertEquals(e.message, Exceptions.INVALID_FRAGMENT_TAG_EXCEPTION)
        }
    }
}