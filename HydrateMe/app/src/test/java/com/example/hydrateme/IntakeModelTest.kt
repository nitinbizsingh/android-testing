package com.example.hydrateme

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class IntakeModelTest {
    private var model: IntakeModel = IntakeModel()

    @Before
    fun setup() {
        val entry1 = IntakeEntry(1000)
        val entry2 = IntakeEntry(2000)
        val entry3 = IntakeEntry(500)

        model.addEntry(entry1)
        model.addEntry(entry2)
        model.addEntry(entry3)
    }

    @Test
    fun total_isCorrect() {
        Assert.assertEquals(3500, model.getTodaysIntake())
    }

    @Test
    fun sufficient_isCorrect() {
        Assert.assertEquals(true, model.isTodaysIntakeSufficient())
    }
}