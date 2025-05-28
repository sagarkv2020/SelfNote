package acn;

/*
split a list of numbers into two subsets such that sum of the subsets are equal, true or false.

Input: [1, 5, 11, 5]
Output: true
Explanation: [1, 5, 5] and [11]

Input: [1, 2, 3, 5]
Output: false

 */
public class PartitionEqualSubsetSum {

    public static void main(String[] args) {
        PartitionEqualSubsetSum partitionEqualSubsetSum = new PartitionEqualSubsetSum();
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,5,11,5}));
        System.out.println(partitionEqualSubsetSum.canPartition(new int[]{1,2,3,5}));

    }

    private boolean canPartition(int[] nums) {
         int total = 0;
        for(int num : nums) total+= num;

        if(total %2 != 0) return false;

        int target = total / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int num : nums) {
            for (int i = target; i >= num; i--) {
                if (dp[i - num]) {
                    dp[i] = true;
                }
            }
        }
        return dp[target];

    }
}
