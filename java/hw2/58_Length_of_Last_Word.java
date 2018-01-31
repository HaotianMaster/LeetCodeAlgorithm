class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.length() == 0) return 0;
        s = s.trim();
        String[] strs = s.split(" ");
        int length = strs[strs.length-1].length();
        return length;
    }
}