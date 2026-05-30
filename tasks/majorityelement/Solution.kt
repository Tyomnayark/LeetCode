package majorityelement


class Solution {
    fun majorityElement(nums: IntArray): Int {
        val map = hashMapOf<Int, Int>()
        for (element in nums) {
            map[element] = map.getOrDefault(element, 0) + 1
        }

        var answer = nums[0]
        for (key in map.keys) {
            map[key]?.let {
                if (it > map.getOrDefault(answer, 0)) {
                    answer = key
                }
            }
        }
        return answer
    }
}