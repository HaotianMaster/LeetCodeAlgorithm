class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> set = new HashSet<>();
        int[] count = new int[256];
        int res = 0, l = 0;
        for (int r = 0; r < s.length(); r++) {
            count[s.charAt(r)]++;
            set.add(s.charAt(r));
            if (set.size() <= 2) {
                res = Math.max(res, r - l + 1);
            }
            else {
                while (set.size() > 2) {
                    count[s.charAt(l)]--;
                    if (count[s.charAt(l)] == 0) set.remove(s.charAt(l));
                    l++;
                }
            }
        }
        return res;
    }
}