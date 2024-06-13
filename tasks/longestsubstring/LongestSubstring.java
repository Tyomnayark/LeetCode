package tasks.longestsubstring;

import java.util.HashMap;

public class LongestSubstring {
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("au"));
    }
    static public int lengthOfLongestSubstring(String s) {
        int maxLength = 0;
        int left = 0;
        HashMap<Byte, Integer> map = new HashMap<>();

        for(int right = 0; right < s.length(); right++){
            byte currentChar = (byte) s.charAt(right);
            if (map.containsKey(currentChar)){
                left =  Math.max(left, map.get(currentChar)+1);
            }
            map.put(currentChar, right);
            maxLength = Math.max(right-left+1 , maxLength);

        }

        return maxLength;
    }
}
