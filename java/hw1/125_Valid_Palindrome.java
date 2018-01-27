// Works
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        //s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
            left++;
            right--;
        }
        return true;
    }
}
// not works! String != Char
class Solution {
    public boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s.toLowerCase();
        int left = 0;
        int right = s.length()-1;
        while (left < right) {
            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) left++;
            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) right--;
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}