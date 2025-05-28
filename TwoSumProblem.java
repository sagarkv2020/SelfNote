package acn;

import java.util.*;

public class TwoSumProblem {
    public static void main(String[] args) {

        int[] nums = new int[]{2, 7, 8, 10};
        int[] answer = find2SumArray(nums, 18);
        System.out.println(Arrays.toString(answer));
    }
    private static int[] find2SumArray(int[] nums, int target) {

        Map<Integer, Integer> map = new HashMap<>(); // value → index

        int complementary;
        for (int i = 0; i < nums.length; i++) {
            complementary = target - nums[i];
            if(map.containsKey(complementary)){
                return new int[]{map.get(complementary),i};
            }
            map.put(nums[i],i);
        }
        return null;
    }
}

