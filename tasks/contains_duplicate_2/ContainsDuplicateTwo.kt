package contains_duplicate_2

class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val window = HashSet<Int>()
        for (i in nums.indices) {
            if (!window.add(nums[i])) return true
            if (window.size > k) window.remove(nums[i - k])
        }
        return false
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    // val array : IntArray = intArrayOf(1,3,4,5,6,8,9,2,5,8,2,4,8,3,6,3,6)
        val array : IntArray = intArrayOf(1,1)
    print(solution.containsNearbyDuplicate(array, 3)) 
}