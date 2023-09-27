package tasks.removeduplicates;

import java.awt.*;
import java.util.*;

public class RemoveDuplicates {
    public static void main(String[] args) {
        System.out.println( removeDuplicates(new int[] {0,0,1,1,1,2,2,3,3,4}));
    }
    static public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0;

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        return slow + 1;
    }
}
