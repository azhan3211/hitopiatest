package com.test.hitopia.function

class HighestPalindrome {

    fun makePalindrome(s: CharArray, k: Int): Pair<CharArray, Int> {
        val n = s.size
        val changes = BooleanArray(n) { false }
        var remainingChanges = k

        var left = 0
        var right = n - 1

        while (left < right) {
            if (s[left] != s[right]) {
                val maxChar = maxOf(s[left], s[right])
                s[left] = maxChar
                s[right] = maxChar
                changes[left] = true
                changes[right] = true
                remainingChanges--
            }
            left++
            right--
        }

        return Pair(s, remainingChanges)
    }

    fun maximizePalindrome(s: CharArray, remainingChanges: Int): String {
        var changesLeft = remainingChanges
        val n = s.size
        val changes = BooleanArray(n) { false }

        var left = 0
        var right = n - 1

        while (left <= right) {
            if (left == right && changesLeft > 0) {
                s[left] = '9'
            } else {
                if (s[left] != '9') {
                    if (changesLeft >= 1 && changes[left]) {
                        s[left] = '9'
                        s[right] = '9'
                        changesLeft--
                    } else if (changesLeft >= 2 && !changes[left]) {
                        s[left] = '9'
                        s[right] = '9'
                        changesLeft -= 2
                    }
                }
            }
            left++
            right--
        }

        return String(s)
    }

    fun getResult(s: String, k: Int): String {
        val (palindromeArray, remainingChanges) = makePalindrome(s.toCharArray(), k)
        if (remainingChanges < 0) return "-1"

        return maximizePalindrome(palindromeArray, remainingChanges)
    }

}