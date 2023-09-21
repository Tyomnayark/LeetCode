package tasks.gpoupanagrams;

import java.util.*;

public class GroupAnagrams {
    public static void main(String[] args) {
        System.out.println(groupAnagrams(new String[]{"eat","tea","tan","ate","nat","bat"}));
    }
    static public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str : strs) {
            byte[] byteArray = str.getBytes();
            Arrays.sort(byteArray);
            String sortedStr = new String(byteArray);

            anagramMap.computeIfAbsent(sortedStr, k -> new  ArrayList<>()).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }

}
