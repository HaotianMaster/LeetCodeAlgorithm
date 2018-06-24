class Solution {
    public boolean isOneEditDistance(String s, String t) {
        if (Math.abs(s.length() - t.length()) > 1 || s.equals(t)) return false;
        int diff = 0;
        if (s.length() == t.length()) {
            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) != t.charAt(i)) diff++;
            }
            if (diff > 1) return false;
        }
        else if (s.length() < t.length()){
            for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    diff++;
                    i--;
                }
            }
            if (diff > 1) return false;
        }
        else {
            for (int i = 0, j = 0; i < s.length() && j < t.length(); i++, j++) {
                if (s.charAt(i) != t.charAt(j)) {
                    diff++;
                    j--;
                }
            }
            if (diff > 1) return false;            
        }
        return true;
    }
}

// A better implementation.
class Solution {
    public boolean isOneEditDistance(String s, String t) {
        int len = Math.min(s.length(), t.length());
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) != t.charAt(i)){
                if (s.length() == t.length()) {
                    return s.substring(i + 1).equals(t.substring(i + 1));
                }
                else if (s.length() < t.length()){
                    return s.substring(i).equals(t.substring(i + 1));       
                }
                else {
                    return s.substring(i + 1).equals(t.substring(i));        
                }                
            }
        }
        return Math.abs(s.length() - t.length()) == 1;
    }
}