// StringBuilder #1
class Solution {
    public String reverseString(String s) {
        StringBuilder sb = new StringBuilder();
        for (int i=s.length()-1; i>=0; i--) {
            sb.append(s.charAt(i));
        }
        return sb.toString();
    }
}
// StringBuilder #2
public class Solution {
    public String reverseString(String s) {
        return new StringBuilder(s).reverse().toString();
    }
}

// Two pointers #3
public class Solution {
    public String reverseString(String s) {
        char[] Chr = s.toCharArray();
        int i = 0;
        int j = Chr.length-1;
        while (i < j) {
            char temp = Chr[i];
            Chr[i] = Chr[j];
            Chr[j] = temp;
            i++;
            j--;
        }
        return new String(Chr);
    }
}

// Recursive solution #4
public class Solution {
    public String reverseString(String s) {
        if (s.length() <= 1) return s;
        int length = s.length();
        String leftsubstring = s.substring(0, length/2);
        String rightsubstring = s.substring(length/2, length);
        return reverseString(rightsubstring) + reverseString(leftsubstring);
    }
}