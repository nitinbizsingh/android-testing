package com.example.hydrateme

import android.content.Context
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.annotation.Config

@RunWith(AndroidJUnit4::class)
@Config(maxSdk = 29)

class MainActivityTest {
    val context = ApplicationProvider.getApplicationContext<Context>()

    @Test
    fun verify_doneString() {
        val doneString: String = context.getString(R.string.done)
        Assert.assertEquals(0, doneString.indexOf("You are done for today"))
    }
}