package tasks.plusone;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        PlusOneJava obj = new PlusOneJava();
             System.out.println(Arrays.toString(obj.plusOne(new int[]{1, 2, 3})));
             System.out.println(Arrays.toString(obj.plusOne(new int[]{9, 9, 9})));
             System.out.println(Arrays.toString(obj.plusOne(new int[]{ 9})));
    }
}
