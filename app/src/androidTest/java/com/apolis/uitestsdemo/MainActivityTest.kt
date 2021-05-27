package com.apolis.uitestsdemo

import android.view.View
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.closeSoftKeyboard
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.hamcrest.CoreMatchers
import org.hamcrest.core.AllOf.allOf
import org.junit.Test
import org.junit.runner.RunWith
import java.util.regex.Matcher


@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @Test
    fun launchMainActivity() {

        ActivityScenario.launch(MainActivity::class.java)

        //find the view, perform some action(click, setting some text), asserting

        val string = "I have typed this"

        onView(withId(R.id.tv_helloWorld)).perform(typeText(string)) //matching + action

        closeSoftKeyboard()

        onView(withId(R.id.button_submit)).perform(click()) //matching + action

        onView(withId(R.id.tv_assertion)).perform(setTextInTextView(string))

        onView(withId(R.id.tv_assertion)).check(matches(withText(string))) //matching + assertion

    }

    private fun setTextInTextView(value: String): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): org.hamcrest.Matcher<View> {
                return CoreMatchers.allOf(ViewMatchers.isDisplayed(), ViewMatchers.isAssignableFrom(TextView::class.java))
            }

            override fun getDescription(): String {
                return "replace text"
            }

            override fun perform(uiController: UiController?, view: View?) {
                (view as TextView).text = value
            }
        }
    }

}