package com.test.hitopia.function

import org.junit.Assert.assertEquals
import org.junit.Test


class WeightedStringTest {

    private val weightedString: WeightedString = WeightedString()

    @Test
    fun `get result abbcccd = 1, 3, 9, 8 = Yes, Yes, Yes, No`() {
        val result = weightedString.getResult("abbcccd", listOf(1, 3, 9, 8))
        val expected = listOf("Yes", "Yes", "Yes", "No")
        assertEquals(expected, result)
    }

    @Test
    fun `get result abcd = 1, 9, 9, 10 = Yes, No, No, No`() {
        val result = weightedString.getResult("abcd", listOf(1, 9, 9, 10))
        val expected = listOf("Yes", "No", "No", "No")
        assertEquals(expected, result)
    }


    @Test
    fun `get result abcd = 10, 26, 8, 3 = No, Yes, Yes, Yes`() {
        val result = weightedString.getResult("aaaiazdd", listOf(10, 26, 8, 3))
        val expected = listOf("No", "Yes", "Yes", "Yes")
        assertEquals(expected, result)
    }
}