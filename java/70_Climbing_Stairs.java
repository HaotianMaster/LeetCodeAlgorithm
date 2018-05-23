class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}

// Space complexity can be optimized.
class Solution {
    public int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int prev = 2;
        int prevprev = 1;
        int curr = 0;
        for (int i = 3; i <= n; i++) {
            curr = prev + prevprev;
            prevprev = prev;
            prev = curr;
            
        }
        return curr;
    }
}