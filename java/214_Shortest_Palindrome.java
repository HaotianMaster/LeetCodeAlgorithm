class Solution {
    public String shortestPalindrome(String s) {
        int left = 0, right = s.length() - 1, end = s.length() - 1;
        char[] sArray = s.toCharArray(); 
        while (left <= right) {
            if (sArray[left] == sArray[right]) {
                left++;
                right--;
            }
            else {
                left = 0;
                end--;
                right = end;
            }
        }
        return new StringBuilder(s.substring(end + 1)).reverse().toString() + s;
    }
}
