class Solution {
    public int minDistance(String word1, String word2) {
        //state: dp[i][j] denotes the minDistance between word1[:i] and word2[:j].
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        //initialization
        dp[0][0] = 0;
        for (int i = 1; i <= word1.length(); i++) {
            dp[i][0] = i;
        }
        for (int j = 1; j <= word2.length(); j++) {
            dp[0][j] = j;
        }
        //Transition Function
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1)) {
                    dp[i][j] = Math.min(dp[i-1][j-1], Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
                else {
                    dp[i][j] = Math.min(dp[i-1][j-1] + 1, Math.min(dp[i-1][j] + 1, dp[i][j-1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }
}