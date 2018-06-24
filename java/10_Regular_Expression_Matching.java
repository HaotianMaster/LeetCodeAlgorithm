class Solution {
    public boolean isMatch(String s, String p) {
        //dp[i][j] denotes weather s[0 : i] matchs with p[0 : j].
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 0; i < p.length(); i++) {
            if (p.charAt(i) == '*' && dp[0][i - 1]) {
                dp[0][i + 1] = true;
            }
        }
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < p.length(); j++) {
                if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {
                    dp[i + 1][j + 1] = dp[i][j];
                }
                //'a*' is treated as multiple a, zero a or single a
                if (p.charAt(j) == '*') {
                    if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {
                        dp[i + 1][j + 1] = dp[i + 1][j - 1]; //'a*' is treated as zero 0 
                    } 
                    else {
                        dp[i + 1][j + 1] = dp[i][j + 1] || dp[i + 1][j - 1] || dp[i + 1][j];
                        //'a*' is treated as multiple a,         zero a         or single a.
                    }
                }                
            }
        }
        return dp[s.length()][p.length()];
    }
}