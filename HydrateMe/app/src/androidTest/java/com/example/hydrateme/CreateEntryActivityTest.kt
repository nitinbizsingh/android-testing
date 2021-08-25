package com.example.hydrateme

import androidx.test.core.app.launchActivity
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.runner.RunWith
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.typeText
import androidx.test.espresso.matcher.ViewMatchers.withId
import org.junit.Assert
import org.junit.Test

@RunWith(AndroidJUnit4::class)
class CreateEntryActivityTest {
    @Test
    fun test_result() {
        val scenario = launchActivity<CreateEntryActivity>()

        onView(withId(R.id.intake_edit_text)).perform(typeText("1000"))
        onView(withId(R.id.add_entry_button)).perform(click())

        val resultData = scenario.result.resultData
        val intake = resultData.getIntExtra("intake", 0)

        Assert.assertEquals(1000, intake)
    }
}