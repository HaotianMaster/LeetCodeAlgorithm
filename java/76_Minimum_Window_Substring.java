//Code from basketwangcoding
class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        int matchCount = 0;
        int[] tArr = new int[256];
        int[] sArr = new int[256];
        String res = "";
        for (char ch : t.toCharArray()) {
            tArr[ch]++;
        }
        int left = findNextStrIdx(0, tArr, s);
        int right = left;
        while (right < s.length()) {
            char rightchar = s.charAt(right);
            if (sArr[rightchar] < tArr[rightchar]) matchCount++;
            sArr[rightchar]++;
            while (matchCount == t.length()) {
                if (res.isEmpty() || res.length() > right-left+1) {
                    res = s.substring(left, right+1);
                }
                char leftchar = s.charAt(left); 
                if (sArr[leftchar] == tArr[leftchar]) matchCount--;
                sArr[leftchar]--;
                left = findNextStrIdx(left+1, tArr, s);
            }
            right = findNextStrIdx(right+1, tArr, s);
        }
        return res;
    }
    public int findNextStrIdx(int start, int[] tArr, String s) {
        while (start < s.length()) {
            if (tArr[s.charAt(start)] != 0) return start;
            start++;
        }
        return start;
    }
}


// Code from bittiger
class Solution {
    public String minWindow(String s, String t) {
        //Corner case checked
        if (s == null || t == null || s.length() == 0 || t.length() == 0) return "";
        
        Map<Character, Integer> frequency = new HashMap<>();
        char[] chS = s.toCharArray();
        for (char c : t.toCharArray()) { //put all characters in t into map
            Integer freq = frequency.get(c);
            if (freq == null) {
                frequency.put(c, 1);
            }
            else {
                frequency.put(c, freq + 1);
            }
        }
        
        int left = 0, right = 0, count = t.length(), minLen = Integer.MAX_VALUE, startIndex = -1;
        
        while (right < chS.length) { //Move right to find a match
            Integer freq = frequency.get(chS[right]);
            if (freq != null) {
                frequency.put(chS[right], freq - 1);
                if (freq > 0) { //in case of overmatch
                    count--;
                }
            }
            right++;
            while (count == 0) { //Move left when a match is found
                if (right - left < minLen) {
                    minLen = right - left;
                    startIndex = left;
                }
                Integer exist = frequency.get(chS[left]);
                if (exist != null) { //update frequency when we are deleting a matched character from this substring
                    frequency.put(chS[left], exist + 1);
                    if (exist == 0) { //while count is 0, exist can only be 0 or negative
                        count++;
                    }
                }
                left++;
            }
        }
        
        return minLen == Integer.MAX_VALUE ? new String() : new String(chS, startIndex, minLen); 
        //new String(char[] c, int offset, int count)
    }
}