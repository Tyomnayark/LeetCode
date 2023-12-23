package tasks.countandsay;

public class Solution {
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }

        String prevSequence = countAndSay(n - 1);
        StringBuilder result = new StringBuilder();
        int count = 1;

        for (int i = 0; i < prevSequence.length(); i++) {
            if (i < prevSequence.length() - 1 && prevSequence.charAt(i) == prevSequence.charAt(i + 1)) {
                count++;
            } else {
                result.append(count).append(prevSequence.charAt(i));
                count = 1;
            }
        }

        return result.toString();
    }
}
