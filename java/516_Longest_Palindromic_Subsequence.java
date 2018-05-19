// O(n^2) time, O(n^2) space.
// 2D-DP
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[][] dp = new int[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j) dp[i][i] = 1;
                else if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = 2 + dp[i+1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i+1][j], dp[i][j-1]);
                }
            }
        }
        return dp[0][s.length()-1];
    }
}

// O(n^2) time, O(n) space.
// 1D-DP, which is an improvement of the 2D-DP.
class Solution {
    public int longestPalindromeSubseq(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int mIJ;
        int mIplus1Jminus1;
        for (int i = s.length() - 1; i >= 0; i--) {     
            dp[i] = 1;
            mIplus1Jminus1 = 0;
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    mIJ = 2 + mIplus1Jminus1;
                }
                else {
                    mIJ = Math.max(dp[j], dp[j-1]);
                }
                mIplus1Jminus1 = dp[j];
                dp[j] = mIJ;
            }
        }
        return dp[s.length()-1];
    }
}