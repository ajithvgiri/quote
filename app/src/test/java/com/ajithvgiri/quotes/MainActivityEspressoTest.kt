package com.ajithvgiri.quotes

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import androidx.test.runner.AndroidJUnit4
import com.ajithvgiri.quotes.ui.MainActivity
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith



@RunWith(AndroidJUnit4::class)
class MainActivityEspressoTest {


    @Rule
    var mActivityRule = ActivityTestRule<MainActivity>(MainActivity::class.java)

    @Test
    @Throws(Exception::class)
    fun pullToRefresh_shouldPass() {
        onView(withId(R.id.swipeRefreshLayout)).perform(swipeDown())
    }

}