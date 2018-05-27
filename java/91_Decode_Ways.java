class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) return 0;
        if (s.charAt(0) == '0') return 0;
        // dp[i] denotes the number of decoding of s(:i).
        int[] dp = new int[s.length() + 1];
        // initialization
        dp[0] = 1; dp[1] = 1;
        // transition function
        for (int i = 2; i <= s.length(); i++) {
            if (s.charAt(i-1) == '0') {
                if (s.charAt(i-2) >= '3' || s.charAt(i-2) <= '0') return 0;
                else dp[i] = dp[i-2];
            }
            else if (s.charAt(i-2) == '0' || Integer.valueOf(s.substring(i-2, i)) > 26) {
                dp[i] = dp[i-1];
            }
            else if (Integer.valueOf(s.substring(i-2, i)) <= 26 && s.charAt(i-1) != '0') {
                dp[i] = dp[i-1] + dp[i-2];
            }
        }       
        return dp[s.length()];
    }
}