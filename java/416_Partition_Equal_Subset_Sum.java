//2D-DP, dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        //Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not. 
        //Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers. 
        //If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];
        for (int i = 0; i <= nums.length; i++) {
            Arrays.fill(dp[i], false);
            dp[i][0] = true;
        }
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = 1; j <= sum; j++) {
                if (j >= nums[i - 1]) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[nums.length][sum];
    }
}

//2D-DP can be optimized to 1D-DP.
class Solution {
    public boolean canPartition(int[] nums) {
        if (nums == null || nums.length == 0) return true;
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) return false;
        sum = sum / 2;
        //Actually, this is a 0/1 knapsack problem, for each number, we can pick it or not. 
        //Let us assume dp[i][j] means whether the specific sum j can be gotten from the first i numbers. 
        //If we can pick such a series of numbers from 0-i whose sum is j, dp[i][j] is true, otherwise it is false.
        boolean[] dp = new boolean[sum + 1];
        Arrays.fill(dp, false);
        dp[0] = true;
        
        for (int i = 1; i <= nums.length; i++) {
            for (int j = sum; j > 0; j--) {
                if (j >= nums[i - 1]) {
                    dp[j] = dp[j] || dp[j - nums[i - 1]];
                }
            }
        }
        return dp[sum];
    }
}