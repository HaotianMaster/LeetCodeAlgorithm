class Solution {
    public int lengthLongestPath(String input) {
        Stack<Integer> st = new Stack<>();
        st.push(0); // "dummy" length
        int res = 0;
        for (String s : input.split("\n")) {
            int level = s.lastIndexOf("\t") + 1;
            while (level + 1 < st.size()) {
                st.pop(); // find parent
            }
            int len = st.peek() + s.length() - level + 1; // remove "/t", add"/"
            st.push(len);
            if (s.contains(".")) {
                res = Math.max(res, len - 1);
            }
        }
        return res;
    }
}