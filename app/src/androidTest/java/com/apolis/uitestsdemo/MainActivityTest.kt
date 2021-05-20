package com.apolis.uitestsdemo

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.TestCase
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Matcher

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun launchMainActivity() {

        ActivityScenario.launch(MainActivity::class.java)

        //find the view, perform some action(click, setting some text), asserting

        onView(withId(R.id.tv_helloWorld)).perform(typeText("I have typed this")) //matching + action

        closeSoftKeyboard()

        onView(withId(R.id.button_submit)).perform(click()) //matching + action

        onView(withId(R.id.tv_assertion)).check(matches(withText("assertion"))) //matching + assertion



    }

}