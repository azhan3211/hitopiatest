package com.test.hitopia.function

import org.junit.Assert.*

import org.junit.Test

class HighestPalindromeTest {

    private val highestPalindrome = HighestPalindrome()

    @Test
    fun `highest palindrome for 3943 is 3993 with k is 1`() {
        val actual = highestPalindrome.getResult("3943", 1)
        val expected = "3993"
        assertEquals(expected, actual)
    }

    @Test
    fun `highest palindrome for 932239 is 992299 with k is 2`() {
        val actual = highestPalindrome.getResult("932239", 2)
        val expected = "992299"
        assertEquals(expected, actual)
    }

    @Test
    fun `highest palindrome for 932239 is 932239 with k is 1 because it cannot formed by given k but still valid number or palindrome`() {
        val actual = highestPalindrome.getResult("932239", 1)
        val expected = "932239"
        assertEquals(expected, actual)
    }

    @Test
    fun `highest palindrome for 932999 is -1 with k is 1 because it cannot formed by given k but still valid number or palindrome`() {
        val actual = highestPalindrome.getResult("932999", 1)
        val expected = "-1"
        assertEquals(expected, actual)
    }
}