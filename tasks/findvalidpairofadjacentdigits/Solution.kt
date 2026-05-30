package findvalidpairofadjacentdigits

class Solution {
    fun findValidPair(s: String): String {
        val map = hashMapOf<Char, Int>()
        for (c in s) {
            map[c] = map.get(c)?.plus(1) ?: 1
        }

        for (i in s.indices){
            if (map[s[i]] == s[i].digitToInt()){
                if ( i > 0 && map[s[i-1]] == s[i-1].digitToInt() && s[i-1] != s[i]){
                    return "${map[s[i-1]]}${map[s[i]]}"
                }
                if( i < s.length - 1 && map[s[i+1]] == s[i+1].digitToInt()&& s[i+1] != s[i]){
                    return "${map[s[i]]}${map[s[i+1]]}"
                }
            }
        }
        return ""
    }
}

fun main() {
    println('2'.digitToInt())
}