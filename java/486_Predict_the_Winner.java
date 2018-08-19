//This is a general min-max algorithm for any arbitrary two player game and is commonly known as the Min-Max algorithm.
//Time complexity: O(2^n). Size of recursion tree will be 2^n. Here, n refers to the length of numsnums array.
//Space complexity: O(n). The depth of the recursion tree can go upto n.
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        return winnerHelper(nums, 0, nums.length-1, 1) >= 0 ? true : false;
    }
    public int winnerHelper(int[] nums, int start, int end, int turn) {
        if (start > end) return 0;
        int c1 = turn * nums[start] + winnerHelper(nums, start+1, end, -turn);
        int c2 = turn * nums[end] + winnerHelper(nums, start, end-1, -turn);
        return turn * Math.max(turn * c1, turn * c2);       
    }
}

// min-max recursion with memorization
// Time complexity : O(n^2). The entire memomemo array of size nnxnn is filled only once. Here, nn refers to the size of numsnums array.
// Space complexity : O(n^2). memomemo array of size nnxnn is used for memoization.
class Solution {
    public boolean PredictTheWinner(int[] nums) {
        Integer[][] memo = new Integer[nums.length][nums.length];
        return winner(nums, 0, nums.length - 1, memo) >= 0;
    }
    public int winner(int[] nums, int s, int e, Integer[][] memo) {
        if (s == e)
            return nums[s];
        if (memo[s][e] != null)
            return memo[s][e];
        int a = nums[s] - winner(nums, s + 1, e, memo);
        int b = nums[e] - winner(nums, s, e - 1, memo);
        memo[s][e] = Math.max(a, b);
        return memo[s][e];
    }
}

//DP is faster than min-max algorithm.
//Time complexity: O(n^2).
//2D-DP
//Based on the above observation, we can say that if know the maximum effective score possible for the subarray nums[x+1,y] and nums[x,y-1], 
//we can easily determine the maximum effective score possible for the subarray nums[x,y] as \text{max}(nums[x]-score_{[x+1,y]}, nums[y]-score_{[x,y-1]})
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