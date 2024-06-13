package tasks.isanagram;

import java.util.Arrays;

public class IsAnagram {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        byte[] sChars = s.getBytes();
        byte[] tChars = t.getBytes();
        Arrays.sort(sChars);
        Arrays.sort(tChars);
        return Arrays.equals(sChars, tChars);
    }
}
