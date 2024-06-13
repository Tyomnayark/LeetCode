package tasks.plusone;

public class PlusOneJava {
    public int[] plusOne(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            int newDigit = digits[i] + 1;
            if (newDigit != 10) {
                digits[i] = newDigit;
                return digits;
            } else {
                digits[i] = 0;
            }
        }

        int[] result = new int[digits.length + 1];
        result[0] = 1;
        return result;
    }
}
