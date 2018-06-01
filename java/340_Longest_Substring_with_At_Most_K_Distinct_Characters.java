// Sliding window + Hashtable
class Solution {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] count = new int[256];
        // num denotes the number of distinct characters.
        // i denotes the left boundary of the window.
        // j denotes the right boundary of the window.
        int num = 0, i = 0, res = 0;
        for (int j = 0; j < s.length(); j++) {
            if (count[s.charAt(j)]++ == 0) num++;
            while (num > k) {
                count[s.charAt(i)]--;
                if (count[s.charAt(i)] == 0) num--;
                i++;
            }
            res = Math.max(res, j - i + 1);
        }
        return res;
    }
}