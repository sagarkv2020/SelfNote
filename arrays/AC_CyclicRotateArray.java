package acn.arrays;

/*
After 1 cyclic right rotation:  [1, 2, 3, 4, 5]  --> should become -> [5, 1, 2, 3, 4]
After 1 cyclic left rotation:   [1, 2, 3, 4, 5]  --> should become -> [ 2, 3, 4, 5, 1]

 */

import java.util.Arrays;
import java.util.stream.Collectors;

public class AC_CyclicRotateArray {
    public static void main(String[] args) {

        int[] nums = new int[]{5, 25, 15, 8, 3, 19, 10};

        System.out.println("Original Array is " + Arrays.stream(nums).boxed().collect(Collectors.toList()));
        System.out.println("Reversed Array is " + Arrays.toString(rotateRight(nums)));

    }

    private static int[] rotateRight(int[] nums) {
        if(nums==null || nums.length ==0)
            throw new  IllegalArgumentException("Empty Array");

        int temp = nums[nums.length-1];
        for(int i=nums.length - 1; i > 0 ;i--){
            nums[i] = nums[i-1];
        }
        nums[0] = temp;

        return nums;
    }

}
