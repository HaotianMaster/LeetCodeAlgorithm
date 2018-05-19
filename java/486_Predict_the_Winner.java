//This is a general min-max algorithm for any arbitrary two player game and is commonly known as the Min-Max algorithm.
//Time complexity: O(2^n). Size of recursion tree will be 2^n. Here, n refers to the length of numsnums array.
//Space complexity: O(n). The depth of the recursion tree can go upto n.
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return winnerHelper(nums, 0, nums.length-1, 1) >= 0 ? true : false;
    }
    public int winnerHelper(int[] nums, int start, int end, int turn) {
        if (end - start < 0) return 0;
        int c1 = turn * nums[start] + winnerHelper(nums, start+1, end, -turn);
        int c2 = turn * nums[end] + winnerHelper(nums, start, end-1, -turn);
        return turn * Math.max(turn * c1, turn * c2);       
    }
}
//DP is faster than min-max algorithm.
//Time complexity: O(n^2).
//2D-DP
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[][] dp = new int[nums.length][nums.length];
        for (int s = nums.length - 1; s >= 0; s--) {
            for (int e = s; e < nums.length; e++) {
                if (e == s) dp[e][s] = nums[s];
                else {
                    int a = nums[s] - dp[s + 1][e];
                    int b = nums[e] - dp[s][e - 1];
                    dp[s][e] = Math.max(a, b);                    
                }
            }
        }
        return dp[0][nums.length - 1] >= 0;
    }
}

//1D-DP
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        int[] dp = new int[nums.length];
        for (int s = nums.length - 1; s >= 0; s--) {
            for (int e = s; e < nums.length; e++) {
                if (e == s) dp[e] = nums[s];
                else {
                    int a = nums[s] - dp[e];
                    int b = nums[e] - dp[e - 1];
                    dp[e] = Math.max(a, b);                    
                }
            }
        }
        return dp[nums.length - 1] >= 0;
    }
}