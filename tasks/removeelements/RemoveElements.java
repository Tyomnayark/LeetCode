package tasks.removeelements;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;

public class RemoveElements {
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,2,3};
        int target = 3;
        System.out.println("lenght " + removeElements(nums, target));
        for (int i = 0; i < nums.length; i++){
            System.out.print(nums[i]+" ");
        }
    }
    static public int removeElements(int[] nums, int target){
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != target) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }

        return index;
    }

}
