package tasks.removeduplicatesintarray

class Solutionkt {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size <= 2) {
            return nums.size
        }

        var k = 2

        for (i in 2 until nums.size) {
            if (nums[i] != nums[k - 1] || nums[i] != nums[k - 2]) {
                nums[k++] = nums[i]
            }
        }
        return k
    }
}