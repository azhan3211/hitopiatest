package com.test.hitopia.function

import org.junit.Assert.*

import org.junit.Test

class BalancedBracketTest {

    private val balancedBracket = BalancedBracket()

    @Test
    fun `return Yes example 1`() {
        val actual = balancedBracket.getResult("{ [ ( ) ] }")
        val expected = "Yes"
        assertEquals(expected, actual)
    }

    @Test
    fun `return No example 2`() {
        val actual = balancedBracket.getResult("{ [ ( ] ) }")
        val expected = "No"
        assertEquals(expected, actual)
    }

    @Test
    fun `return Yes example 3`() {
        val actual = balancedBracket.getResult("{ ( ( [ ] ) [ ] ) [ ] }")
        val expected = "Yes"
        assertEquals(expected, actual)
    }
}