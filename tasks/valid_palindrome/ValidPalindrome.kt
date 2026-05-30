package valid_palindome

class Solution {
  fun isPalindrome(s: String): Boolean {                             
      var i = 0                                                      
      var j = s.length - 1                                           
      while (i < j) {                                             
          if (!s[i].isLetterOrDigit()) { i++; continue }             
          if (!s[j].isLetterOrDigit()) { j--; continue }
          if (s[i].lowercaseChar() != s[j].lowercaseChar()) return false                                                              
          i++; j--
      }                                                              
      return true                                                 
  }    

}

fun main(args: Array<String>) {
    val solution = Solution()
    print(solution.isPalindrome("A man, a plan, a canal: Panama"))
}