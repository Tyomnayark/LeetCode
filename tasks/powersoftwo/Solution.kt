package powersoftwo

class Solution {
    fun isPowerOfTwo(n: Int): Boolean {
        if ((n and (n-1) ) == 0 && n > 0){
            return true
        }
        return false
    }
}