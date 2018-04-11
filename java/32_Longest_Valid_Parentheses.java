//Stack, O(n) time, O(n) space.
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        int start = -1;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            }
            else {
                if (st.isEmpty()) {
                    start = i;
                }
                else {
                    st.pop();
                    if (st.isEmpty()) {
                        res = Math.max(res, i - start);
                    }
                    else {
                        res = Math.max(res, i - st.peek());
                    }
                }
            }
        }
        return res;
    }
}
//Stack, same idea but better coding. 
class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> st = new Stack<>();
        int res = 0;
        st.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                st.push(i);
            }
            else {
                st.pop();
                if (st.isEmpty()) {
                    st.push(i);
                }
                else {
                    res = Math.max(res, i - st.peek());
                }
            }
        }
        return res;
    }
}