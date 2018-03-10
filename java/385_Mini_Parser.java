class Solution {
    public NestedInteger deserialize(String s) {
        if (!s.startsWith("[")) return new NestedInteger(Integer.valueOf(s));
        int curr = 0;  // The current num.
        int flag = -1; // To judge whether we have valid num now.
        int sign = 1;  
        Stack<NestedInteger> st = new Stack<>();
        NestedInteger res = new NestedInteger();
        st.push(res);
        for (int i = 1; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = s.charAt(i+1) - '0' + num * 10;
                    i++;
                }
                curr = num * sign;
                flag = 1;
            }
            else if (s.charAt(i) == '[') {
                NestedInteger ni = new NestedInteger();
                st.peek().add(ni);
                st.push(ni);
            }
            else if (s.charAt(i) == ']' || s.charAt(i) == ',') {
                if (s.charAt(i-1) != ']' && flag == 1) st.peek().add(new NestedInteger(curr));
                if (s.charAt(i) == ']') st.pop();
                sign = 1;
                flag = -1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
        }
        return res;
    }
}