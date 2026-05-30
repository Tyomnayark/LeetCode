package gpoupanagrams

class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = hashMapOf<String, MutableList<String>>()
        for (s in strs) {
            val sortedBytes = s.toByteArray().sorted()
            val sortedStr = sortedBytes.toString()
            val list = map[sortedStr] ?: mutableListOf()
            list.add(s)
            map[sortedStr] = list
        }
        return map.values.toList()
    }
}

fun main() {
    val solution = Solution()
    val res = solution.groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat"))
    res.forEach { println(it) }
}