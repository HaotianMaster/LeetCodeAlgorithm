class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s.length() > t.length()) return false;
        int i = 0, j = 0;
        while (i < s.length() && j < t.length()) {
            if (s.charAt(i) == t.charAt(j++)) i++;
        }
        
        return i == s.length() ? true : false;        
    }
}

/**
 * Follow up:
 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
 * 
 * If we check each sk in this way, then it would be O(kn) time where k is the number of s and t is the length of t. 
 * This is inefficient. 
 * Since there is a lot of s, it would be reasonable to preprocess t to generate something that is easy to search for if a character of s is in t. 
 * Sounds like a HashMap, which is super suitable for search for existing stuff. 
 */

class Solution {
    public boolean isSubsequence(String s, String t) {
        if (s == null || t == null) return false;
        if (s.length() > t.length()) return false;
        
        Map<Character, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            char curr = t.charAt(i);
            if (!map.containsKey(curr)) {
                map.put(curr, new ArrayList<Integer>());
            }
            map.get(curr).add(i);
        }
        
        int prev = -1; //index of previous character
        for (int i = 0; i < s.length(); i++) {
            char curr = s.charAt(i);
            if (map.get(curr) == null) return false;
            List<Integer> list = map.get(curr);
            prev = binarySearch(prev, list, 0, list.size() - 1);
            if (prev == -1) return false;
        }
        return true;
    }
    
    public int binarySearch(int prev, List<Integer> list, int start, int end) {
        while (start + 1 < end) {
            int mid  = start + (end - start) / 2;
            if (list.get(mid) <= prev) {
                start = mid;
            }
            else {
                end = mid;
            }
        }
        if (list.get(start) > prev && start <= end) return list.get(start);
        if (list.get(end) > prev) return list.get(end);
        return -1;
    }
}