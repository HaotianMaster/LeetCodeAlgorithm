class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> st = new ArrayDeque<>();
        int sum = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int num = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = s.charAt(i+1) - '0' + num * 10;
                    i++;
                }
                sum += num * sign;
            }
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                sum = sum * st.pop() + st.pop();
            }
        }
        return sum;
    }
}

// Input: "2147483647"
// Output: -1944461066
// Expected: 2147483647
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        Deque<Integer> st = new ArrayDeque<>();
        int sum = 0;
        int sign = 1;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                int j = i+1;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                sum += Integer.valueOf(s.substring(i, j)) * sign;
            }
            else if (s.charAt(i) == '+') {
                sign = 1;
            }
            else if (s.charAt(i) == '-') {
                sign = -1;
            }
            else if (s.charAt(i) == '(') {
                st.push(sum);
                st.push(sign);
                sum = 0;
                sign = 1;
            }
            else if (s.charAt(i) == ')') {
                sum = sum * st.pop() + st.pop();
            }
        }
        return sum;
    }
}