class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int i = 0; int j = s.length()-1;
        while (i <= j) {
            if (s.charAt(i) != s.charAt(j)) return false;
            i++;
            j--;
        }
        return true;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int div = 1; int num = x;
        while (x/div >= 10) div *= 10;
        while (num > 0) {
            int left = num/div;
            int right = num%10;
            if (left != right) return false;
            num = (num - left*div - right)/10;
            div /= 100;
        }
        return true;
    }
}