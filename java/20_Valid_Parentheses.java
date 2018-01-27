class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() < 2) return false;
        Stack<Character> st = new Stack<>();
        for (int i=0; i<s.length(); i++) {
            if (st.isEmpty() || s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[') st.push(s.charAt(i));
            else if (s.charAt(i) == ')' && st.pop() != '(') return false;
            else if (s.charAt(i) == '}' && st.pop() != '{') return false;
            else if (s.charAt(i) == ']' && st.pop() != '[') return false;
        }
        if (!st.isEmpty()) return false;
        return true;
    }
}