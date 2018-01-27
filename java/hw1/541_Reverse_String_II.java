// My first implementation.
class Solution {
    public String reverseStr(String s, int k) {
        if (s.length() < k) return reverse(s, 0, s.length()-1);
        if (s.length() >= k && s.length()<2*k) return reverse(s, 0, k-1);
        for (int i=0; i<s.length(); i+=2*k) {
            if (i+k-1 < s.length()) s = reverse(s, i, i+k-1);
            else s = reverse(s, i, s.length()-1);
        }
        return s;
    }
    public String reverse(String s, int start, int end) {
        StringBuilder sb = new StringBuilder();
        char[] charstr = s.toCharArray();
        while (start < end) {
            char temp = charstr[start];
            charstr[start] = charstr[end];
            charstr[end] = temp;
            start++;
            end--;
        }
        for (int i=0; i<s.length(); i++) sb.append(charstr[i]);
        return sb.toString();
    }
}

// My revised implementation.
class Solution {
    public String reverseStr(String s, int k) {
        StringBuilder sb = new StringBuilder();
        char[] charstr = s.toCharArray();
        for (int i=0; i<s.length(); i+=2*k) {
            if (i+k-1 < s.length()) reverse(charstr, i, i+k-1);
            else reverse(charstr, i, s.length()-1);
        }
        for (int i=0; i<s.length(); i++) sb.append(charstr[i]);
        return sb.toString();
    }
    public void reverse(char[] charstr, int start, int end) {        
        while (start < end) {
            char temp = charstr[start];
            charstr[start] = charstr[end];
            charstr[end] = temp;
            start++;
            end--;
        }
    }
}