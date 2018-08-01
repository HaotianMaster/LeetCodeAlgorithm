// Stack
class Solution {
    public boolean backspaceCompare(String S, String T) {
        Stack<Character> st1 = new Stack<>();
        Stack<Character> st2 = new Stack<>();
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) != '#') {
                st1.push(S.charAt(i));
            }
            else {
                if (!st1.isEmpty()) st1.pop();
            }
        }
        for (int i = 0; i < T.length(); i++) {
            if (T.charAt(i) != '#') {
                st2.push(T.charAt(i));
            }
            else {
                if (!st2.isEmpty()) st2.pop();
            }
        }
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        sb1.append("");
        sb2.append("");
        while (!st1.isEmpty()) {
            sb1.append(st1.pop());
        }
        while (!st2.isEmpty()) {
            sb2.append(st2.pop());
        }
        String s1 = sb1.toString();
        String s2 = sb2.toString();
        return s1.equals(s2);
    }
}

// Two pointer
class Solution {
    public boolean backspaceCompare(String S, String T) {
        int i = S.length() - 1, j = T.length() - 1;
        int c1 = 0, c2 = 0; 
        while (true) {
            while(i >= 0 && (S.charAt(i) == '#' || c1 > 0)){
                c1 += S.charAt(i) == '#' ? 1 : -1;
                i--;
            }
            while(j >= 0 && (T.charAt(j) == '#' || c2 > 0)){
                c2 += T.charAt(j) == '#' ? 1 : -1;
                j--;
            }
            if (i < 0 && j < 0) return true;
            if (i < 0 || j < 0) return false;
            if (S.charAt(i) != T.charAt(j)) return false;
            i--;
            j--;
        }
    }
}