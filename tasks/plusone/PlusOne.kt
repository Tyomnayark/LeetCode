package tasks.plusone

class PlusOne {
}

fun main(args: Array<String>) {
    val solution = Solution()
    solution.plusOne(intArrayOf(1, 2, 3)).forEach { print(it) }
    println()
    solution.plusOne(intArrayOf(9, 9, 9)).forEach { print(it) }
    println()
    solution.plusOne(intArrayOf(9)).forEach { print(it) }
}

class Solution {
    fun plusOne(digits: IntArray): IntArray {
        for (index in digits.lastIndex downTo 0) {
            val newDig = digits[index].inc()
            when {
                newDig != 10 -> {
                    digits[index] = newDig
                    return digits
                }
                else -> digits[index] = 0
            }
        }
        return intArrayOf(1) + digits
    }
}
