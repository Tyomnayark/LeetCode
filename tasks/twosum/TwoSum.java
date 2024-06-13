package tasks.twosum;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numIndexes = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numIndexes.containsKey(complement)) {
                return new int[]{numIndexes.get(complement), i};
            }
            numIndexes.put(nums[i], i);
        }

        throw new IllegalArgumentException("No two sum solution");
    }
}
