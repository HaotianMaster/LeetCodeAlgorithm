class Solution {
    public String decodeString(String s) {
        String res = "";
        Stack<Integer> k = new Stack<>();
        Stack<String> pre_res = new Stack<>();
        int i = 0;
        while (i < s.length()) {
            if (s.charAt(i) - '0' < 10) {
                String num = "";
                while (s.charAt(i) - '0' < 10) {
                    num += s.charAt(i);
                    i++;
                }
                k.push(Integer.valueOf(num));
            }
            else if (s.charAt(i) == '[') {
                pre_res.push(res);
                res = "";
                i++;
            }
            else if (s.charAt(i) == ']') {
                StringBuilder sb = new StringBuilder();
                int repeat = k.pop();
                while (repeat > 0) {
                    sb.append(res);
                    repeat--;
                }
                res = pre_res.pop() + sb.toString();
                i++;
            }
            else {
                res += s.charAt(i);
                i++;
            }
        }
        return res;
    }
}