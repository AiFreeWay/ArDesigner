package tech.intom.kopilka.presentation

import android.support.test.filters.LargeTest
import android.support.test.runner.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import android.support.test.rule.ActivityTestRule
import org.junit.Rule
import tech.intom.kopilka.presentation.views.activities.SplashActivity


/**
 * Created by root on 04.04.18.
 */
@RunWith(AndroidJUnit4::class)
@LargeTest
class SplashScreenTest {

    @get:Rule
    val mActivityRule = ActivityTestRule<SplashActivity>(SplashActivity::class.java)

    @Test
    fun testGoToMainScreen() {
        val splashActivity = mActivityRule.activity
        splashActivity.showMainScreen()
        Assert.assertEquals(splashActivity.isFinishing, true)
    }
}