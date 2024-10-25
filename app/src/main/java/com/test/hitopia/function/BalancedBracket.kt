package com.test.hitopia.function

class BalancedBracket {

    fun getResult(input: String): String {
        val stack = ArrayDeque<Char>()
        val openBrackets = listOf('(', '{', '[')
        val formattedInput = input.replace(" ", "")
        formattedInput.forEach {
            if (openBrackets.contains(it)) {
                stack.add(it)
            } else {
                when (it) {
                    ')' -> {
                        if (stack.last() == '(') {
                            stack.removeLast()
                        } else {
                            return "No"
                        }
                    }
                    '}' -> {
                        if (stack.last() == '{') {
                            stack.removeLast()
                        } else {
                            return "No"
                        }
                    }
                    ']' -> {
                        if (stack.last() == '[') {
                            stack.removeLast()
                        } else {
                            return "No"
                        }
                    }
                }
            }
        }
        if (stack.isNotEmpty()) {
            return "No"
        }
        return "Yes"
    }

}