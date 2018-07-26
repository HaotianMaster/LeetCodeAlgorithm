class Solution {
    public int numTrees(int n) {
        if (n <= 1) return 1;
        // The number of unique BST for a sequence of length n.
        int[] dp = new int[n + 1];
        dp[0] = 1; //empty tree
        dp[1] = 1; //the tree with only one node
        // F(3,7) = G(2) * G(4)
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i] += dp[j - 1] * dp[i - j];
            }
        }
        return dp[n];        
    }
}