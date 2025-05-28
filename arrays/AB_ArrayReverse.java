package acn.arrays;

import java.util.Arrays;
import java.util.stream.Collectors;

public class AB_ArrayReverse {

    public static void main(String[] args) {

        int[] nums = new int[]{5, 25, 15, 8, 3, 19, 10};

        System.out.println("Original Array is " + Arrays.stream(nums).boxed().collect(Collectors.toList()));
        System.out.println("Reversed Array is " + Arrays.toString(reverseArray(nums)));


    }



    private static int[] reverseArray(int[] nums) {
        if(nums==null || nums.length ==0)
            throw new  IllegalArgumentException("Empty Array");

        //This is a 2-pointer approach
        for(int i=0, j=nums.length-1 ; i<j ; i++, j--){
            int tmp = nums[i];
            nums[i]=nums[j];
            nums[j] = tmp;
        }
        return nums;
    }


}
