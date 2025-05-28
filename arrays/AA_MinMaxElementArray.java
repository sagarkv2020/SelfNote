package acn.arrays;

public class AA_MinMaxElementArray {


    public static void main(String[] args) {

        int[] nums = new int[]{5, 25, 15, 8, 3, 19, 10};

        System.out.println("Minimum # is " + findMinimum(nums));
        System.out.println("Maximum # is " + findMaximum(nums));

    }

    private static int findMinimum(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("Array is null or empty");

        int min = nums[0];
        for (int num : nums) {
            if (num < min) min = num;
        }
        return min;
    }

    private static int findMaximum(int[] nums) {
        if (nums == null || nums.length == 0)
            throw new IllegalArgumentException("Array is null or empty");


        int max = nums[0];
        for (int num : nums) {
            if (num > max) max = num;
        }
        return max;

    }
}

