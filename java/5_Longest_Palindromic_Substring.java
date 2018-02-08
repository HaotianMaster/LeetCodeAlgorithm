// DP. O(n^2) time, O(n^2) space. 
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] bool = new boolean[s.length()][s.length()];
        String results = s.substring(0,1);
        //Initilze all the "a" and "aa" cases as true.
        for (int i=0; i<s.length(); i++) {
            bool[i][i] = true;
            if (i != 0 && s.charAt(i) == s.charAt(i-1)) {
                bool[i-1][i] = true;
                results = s.substring(i-1,i+1);
            }
        }
        
        for (int i=s.length()-3; i>=0; i--) {
            for (int j=i+2; j<s.length(); j++) {
                if (bool[i+1][j-1] == true && s.charAt(i) == s.charAt(j)) {
                    bool[i][j] = true;
                    if (j-i+1 > results.length()) results = s.substring(i,j+1);
                }
            }
        }
        return results;
    }
}
// DP. Better implementation.
class Solution {
    public String longestPalindrome(String s) {
        boolean[][] bool = new boolean[s.length()][s.length()];
        String results = "";       
        for (int i=s.length(); i>=0; i--) {
            for (int j=i; j<s.length(); j++) {
                if (s.charAt(i) == s.charAt(j) && (j-i<2 || bool[i+1][j-1] == true)) {
                    bool[i][j] = true;
                    if (j-i+1 > results.length()) results = s.substring(i,j+1);
                }
            }
        }
        return results;
    }
}

// Expand around center
// O(n^2) time, O(1) space.
class Solution {
    public String longestPalindrome(String s) {
        String results = "";        
        for (int i=0; i<s.length(); i++) {
            String s1 = getLongestPalindrome(s, i, i); //bab
            String s2 = getLongestPalindrome(s, i, i+1);//baab
            String curr = s1.length() > s2.length() ? s1 : s2;
            if (curr.length() > results.length()) results = curr;
        }
        return results;
    }
    public String getLongestPalindrome(String s, int left, int right) {
        int L = left;
        int R = right;
        while (L >= 0 && R < s.length() && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        if (L+1 != R) return s.substring(L+1, R);
        return "";
    }
}







