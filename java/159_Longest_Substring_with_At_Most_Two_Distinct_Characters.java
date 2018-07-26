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

class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Set<Character> set = new HashSet<>();
        Map<Character, Integer> map = new HashMap<>();
        int l = 0;
        int res = 0;
        for (int r = 0; r < s.length(); r++) {
            char ch_r = s.charAt(r);
            set.add(ch_r);
            map.put(ch_r, map.getOrDefault(ch_r, 0) + 1);
            while (set.size() > 2) {
                char ch_l = s.charAt(l++);
                map.put(ch_l, map.get(ch_l) - 1);
                if (map.get(ch_l) == 0) {
                    set.remove(ch_l);
                }
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }
}