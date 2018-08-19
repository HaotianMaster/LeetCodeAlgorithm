// DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++) {
            for (String str: wordDict) {
                if (str.length() <= i && dp[i - str.length()]) {
                    if (s.substring(i - str.length(), i).equals(str)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        
        return dp[s.length()];        
    }
}

// Second DP, but much slower than the first version.
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        
        for (int i = 1; i <= s.length(); i++){
            for (int j = 0; j < i; j++){
                if (dp[j] && wordDict.contains(s.substring(j, i))){
                    dp[i] = true;
                    break;
                }
            }
        }
        
        return dp[s.length()];        
    }
}