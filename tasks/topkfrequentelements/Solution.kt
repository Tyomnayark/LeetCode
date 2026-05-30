package topkfrequentelements

class Solution {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val map = hashMapOf<Int, Int>()
        for(num in nums){
            map[num] = map.getOrDefault(num, 0) + 1
        }
        val array = quickSort(map.keys.toList(), map)
        return array.slice(array.size - k until array.size  ).toIntArray()
    }

    fun quickSort(list: List<Int>, map: HashMap<Int, Int>): List<Int> {
        if (list.size <= 1) return list
        val pivot = list[list.size / 2]
        val less = list.filter { map[it]!! < map[pivot]!!}
        val equal = list.filter { map[it]!! == map[pivot]!! }
        val greater = list.filter { map[it]!! > map[pivot]!! }
        return quickSort(less, map) + equal + quickSort(greater, map)
    }

    fun partition(arr: IntArray, low: Int, high: Int, map: HashMap<Int, Int>): Int {
        val pivot = arr[high]
        var i = low - 1
        for (j in low until high) {
            if ((map[arr[j]] ?: 0) <= (map[pivot] ?: 0)) {
                i++
                val tmp = arr[i]; arr[i] = arr[j]; arr[j] = tmp
            }
        }
        val tmp = arr[i + 1]; arr[i + 1] = arr[high]; arr[high] = tmp
        return i + 1
    }

}