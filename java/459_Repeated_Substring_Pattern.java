//The length of the repeating substring must be a divisor of the length of the input string
//Search for all possible divisor of str.length, starting for length/2
class Solution {
    public boolean repeatedSubstringPattern(String s) {
        if (s == null || s.length() == 0) return true;
        if (s.length() == 1) return false;
        int n = 2;
        while (n <= s.length()) { 
            if (s.length()%n == 0) {
                int i = s.length()/n;
                StringBuilder sb = new StringBuilder();
                String curr = s.substring(0, i);
                for (int j=0; j<n; j++) sb.append(curr);
                String repeated = sb.toString();
                if (repeated.equals(s)) return true;                
            }
            n++;
        }
        return false;
    }
}