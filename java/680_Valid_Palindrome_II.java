class Solution {
    public boolean validPalindrome(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;
        while (str[left] == str[right]) {
            left++;
            right--;
            if (left >= right) return true;
        }
        int storeleft = left;
        int storeright = right;
        int newright = storeright-1;
        int newleft = storeleft+1;
        while (str[left] == str[newright]) {
            left++;
            newright--;
            if (left >= newright) return true;
        }
        while (str[newleft] == str[right]) {
            newleft++;
            right--;
            if (newleft >= right) return true;
        }
        return false;
    }
}

class Solution {
    public boolean validPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        int left = 0; int right = s.length()-1;
        while (s.charAt(left) == s.charAt(right)) {
            left++;
            right--;                
            if (left >= right) return true;
        }
        int currleft = left+1;
        int currright = right-1;
        while (s.charAt(left) == s.charAt(currright)) {
            left++;
            currright--;                    
            if (left >= currright) return true;
        }
        while (s.charAt(currleft) == s.charAt(right)) {
            currleft++;
            right--;                
            if (currleft >= right) return true;
        }
        return false;
    }
}