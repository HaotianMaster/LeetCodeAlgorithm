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