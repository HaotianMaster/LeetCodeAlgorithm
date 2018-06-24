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

class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0) return true;
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']') {
                if (st.size() == 0) return false;
                else {
                    char ch = st.pop();
                    if (s.charAt(i) == ')' && ch != '(') {
                        return false;
                    }
                    else if (s.charAt(i) == '}' && ch != '{') {
                        return false;
                    }
                    else if (s.charAt(i) == ']' && ch != '[') {
                        return false;
                    }
                }
            }
            else {
                st.push(s.charAt(i));
            }
        }
        if (st.size() > 0) return false;
        return true;
    }
}