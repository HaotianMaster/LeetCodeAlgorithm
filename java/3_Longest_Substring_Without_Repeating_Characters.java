class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] count = new int[256];
        int l = 0, res = 0;
        for (int r = 0; r < s.length(); r++) {
            Character ch_r = s.charAt(r);
            Character ch_l = s.charAt(l);
            count[ch_r]++;
            if (count[ch_r] == 1) {
                res = Math.max(res, r - l + 1);
            }
            else {  
                while (l <= r && count[ch_r] > 1) {
                    l++;
                    count[ch_l]--;
                    ch_l = s.charAt(l);
                }
            }
        }
        return res;
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