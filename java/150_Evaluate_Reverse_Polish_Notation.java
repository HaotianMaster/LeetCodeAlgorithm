class Solution {
    public int evalRPN(String[] tokens) {
        if (tokens == null || tokens.length == 0) return 0;
        int a, b;
        Stack<Integer> st = new Stack<>();
        for (String token : tokens) {
            if (token.equals("+")) {
                a = st.pop();
                b = st.pop();
                st.push(a+b);
            }
            else if (token.equals("-")) {
                a = st.pop();
                b = st.pop();
                st.push(b-a);                
            }
            else if (token.equals("*")) {
                a = st.pop();
                b = st.pop();
                st.push(a*b);                
            }
            else if (token.equals("/")) {
                a = st.pop();
                b = st.pop();
                st.push(b/a);                
            }
            else {
                st.push(Integer.valueOf(token));
            }
        }
        return st.pop();
    }
}