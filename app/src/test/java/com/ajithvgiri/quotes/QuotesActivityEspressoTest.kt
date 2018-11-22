package com.ajithvgiri.quotes

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions.swipeDown
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import com.ajithvgiri.quotes.ui.quotes.QuotesActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class QuotesActivityEspressoTest {


    @Rule
    var mActivityRule = ActivityTestRule<QuotesActivity>(QuotesActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun pullToRefresh_shouldPass() {
        onView(withId(R.id.swipeRefreshLayout)).perform(swipeDown())
    }

}