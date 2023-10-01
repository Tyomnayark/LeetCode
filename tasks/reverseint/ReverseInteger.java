package tasks.reverseint;

public class ReverseInteger {
    public static void main(String[] args) {
        System.out.println(reverse(123));
        System.out.println(reverse(-123));
    }
    static public int reverse(int x){
        int reversed = 0;

        while (x != 0) {
            int lastDigit = x % 10;
            x /= 10;

            if (reversed > Integer.MAX_VALUE / 10 || (reversed == Integer.MAX_VALUE / 10 && lastDigit > 7)) {
                return 0;
            }
            if (reversed < Integer.MIN_VALUE / 10 || (reversed == Integer.MIN_VALUE / 10 && lastDigit < -8)) {
                return 0;
            }

            reversed = reversed * 10 + lastDigit;
        }

        return reversed;

    }
}
