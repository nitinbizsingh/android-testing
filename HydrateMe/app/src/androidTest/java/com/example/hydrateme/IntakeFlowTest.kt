package com.example.hydrateme

import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Rule
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class IntakeFlowTest {
    @get:Rule
    var activityRule: ActivityScenarioRule<MainActivity>
            = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun test_intake_flow() {
        onView(withId(R.id.create_entry_fab)).perform(click())

        onView(withId(R.id.intake_edit_text)).perform(typeText("1000"))
        onView(withId(R.id.add_entry_button)).perform(click())

        onView(withId(R.id.total)).check(matches(withText("1000 ml")))
    }
}