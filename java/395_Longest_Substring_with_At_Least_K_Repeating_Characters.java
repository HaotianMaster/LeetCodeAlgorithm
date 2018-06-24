// Divide and conquer 
class Solution {
    public int longestSubstring(String s, int k) {
        return helper(s, 0, s.length() - 1, k);
    }
    public int helper(String s, int start, int end, int k) {
        if (end - start + 1 < k) return 0;
        int[] count = new int[26];
        for (int i = start; i <= end; i++) {
            count[s.charAt(i) - 'a']++;
        }
        for (int i = start; i <= end; i++) {
            if (count[s.charAt(i) - 'a'] < k) {
                int left = helper(s, start, i - 1, k);
                int right = helper(s, i + 1, end, k);
                return Math.max(left, right);
            }
        }
        return end - start + 1;
    }
}

//Same idea actually, but beat 100%.
public class Solution {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0) return 0;
        char[] chars = new char[26];
        // record the frequency of each character
        for (int i = 0; i < s.length(); i += 1) chars[s.charAt(i) - 'a'] += 1;
        boolean flag = true;
        for (int i = 0; i < chars.length; i += 1) {
            if (chars[i] < k && chars[i] > 0) flag = false;
        }
        // return the length of string if this string is a valid string
        if (flag == true) return s.length();
        int result = 0;
        int start = 0, cur = 0;
        // otherwise we use all the infrequent elements as splits
        while (cur < s.length()) {
            if (chars[s.charAt(cur) - 'a'] < k) {
                result = Math.max(result, longestSubstring(s.substring(start, cur), k));
                start = cur + 1;
            }
            cur++;
        }
        result = Math.max(result, longestSubstring(s.substring(start), k));
        return result;
    }
}