package minimumindexofvalidsplit

class Solution {
    fun minimumIndex(nums: List<Int>): Int {
        var dominant = -1
        val map = hashMapOf<Int, Int>()
        nums.forEach { key ->
            map[key] = map.getOrDefault(key, 0) + 1
            map[key]?.let {
                if (it > nums.size / 2) {
                    dominant = key
                    return@forEach
                }
            }
        }

        var dominantCounter = 0
        for (i in 0 until nums.size ) {
            if (nums[i] == dominant) {
                dominantCounter++
                if(i / 2 < dominantCounter && (nums.size - 1 - i) / 2 < ((map[dominant] ?: 0) - dominantCounter)) {
                    return i
                }
            }
        }
        return -1
    }

}

fun main() {
    val solution = Solution()
    println(solution.minimumIndex(listOf(1,2,3,3,3,3)))
}