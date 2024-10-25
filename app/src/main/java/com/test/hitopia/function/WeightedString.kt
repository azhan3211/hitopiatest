package com.test.hitopia.function

class WeightedString {

    fun getResult(input: String, queries: List<Int>): List<String> {
        val sums = mutableSetOf<Int>()
        var i = 0
        val size = input.length

        while (i < size) {
            val char = input[i]
            val weight = char - 'a' + 1
            var count = 1

            while (i < size && input[i] == char) {
                sums.add(weight * count)
                count++
                i++
            }
        }

        return queries.map { if (it in sums) "Yes" else "No" }
    }

}