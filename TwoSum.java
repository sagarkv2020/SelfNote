package leetcode;
/*
//Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

Example 1:
Input: nums = [2,7,11,15], target = 9
Output: [0,1]

Example 2:
Input: nums = [3,2,4], target = 6
Output: [1,2]

Example 3:
Input: nums = [3,3], target = 6
Output: [0,1]

 */

import java.util.Arrays;

public class TwoSum {

    public static void main(String[] args) {

        int[] intArray = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        System.out.println(intArray.length);
        System.out.println(Arrays.toString(twoSum(intArray, 17)));

    }

    public static int[] twoSum(int[] nums, int target) {
        int[] arr = new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < nums.length; j++) {
                if((nums[i]+nums[j] == target) && i!=j){
                    arr[0] = i;
                    arr[1] = j;
                }
            }
        }
        return arr;
    }
}

/*



Le































 */