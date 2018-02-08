// My initial solution. Although it cannot be accepted by this question,
// but if String s only contain character from 'a' to 'z', it should works. 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] count = new int[26];
        int max = 0;
        int i = 0;
        for (int j=0; j<s.length(); j++) {
            int curr = s.charAt(j)-'a';
            if (count[curr] != 0) {
                count[curr]++;
                while (count[s.charAt(i)-'a'] < 2) i++;
                i++;
                count[curr]--;
            }
            else {
                count[curr]++;
            }
            max = Math.max(max, j-i);
        }
        return max;
    }
}

// Sliding windows. 
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0; 
        for (int j=0; j<s.length(); j++) {
            while (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i++));
            }
            set.add(s.charAt(j));
            max = Math.max(max, j-i+1);
        }
        return max;
    }
}
// Sliding windows. Another implementation.
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) return 0;
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int i = 0; int j = 0;
        while (i < s.length() && j < s.length()) {
            if (!set.contains(s.charAt(j))) {
                set.add(s.charAt(j++));
                max = Math.max(max, j - i);
            }
            else {
                while (set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i++));
                }
            }
        }
        return max;
    }
}