class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        String trimmed = s.trim();
        if (trimmed.equals("")) return 0;
        String[] strs = trimmed.split("\\s+");
        return strs.length;
    }
}

class Solution {
    public int countSegments(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for (int i=0; i<s.length(); i++) {
            if ((i == 0 || s.charAt(i-1) == ' ') && s.charAt(i) != ' ') {
                count++;
            }
        }
        return count;
    }
}