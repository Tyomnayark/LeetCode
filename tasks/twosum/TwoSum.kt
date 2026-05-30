package twosum

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()
        for (i in nums.indices) {
            val digitToFind = target - nums[i]
            val j = hashMap[digitToFind]
            if (j != null){
                return intArrayOf(i, j)
            } 
            hashMap[nums[i]] = i
        }
            return intArrayOf()
    }
}

fun main(args: Array<String>) {
    val solution = Solution()
    for (i in solution.twoSum(intArrayOf(1,3,4,2), 6)){
    print( "$i;")
    }
}
