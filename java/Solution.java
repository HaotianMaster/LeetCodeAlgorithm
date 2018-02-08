import java.util.*;
class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        System.out.println(s);
        int i = 0; int j = s.length()-1;
        System.out.println(i);
        System.out.println(j);
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return false;
    }

    public static void main(String[] args) {
    int x = 0;
	Solution sol = new Solution();
	sol.isPalindrome(x);        
    }
}
