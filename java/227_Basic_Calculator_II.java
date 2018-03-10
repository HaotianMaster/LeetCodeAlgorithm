// Using Stack. O(n) time, O(n) space.
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        char sign = '+';
        int num = 0;
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = s.charAt(i+1) - '0' + num * 10;
                    i++;
                }
            }
            else if (s.charAt(i) != ' ') {
                if (sign == '+') st.push(num);
                if (sign == '-') st.push(-num);
                if (sign == '*') st.push(st.pop()*num);
                if (sign == '/') st.push(st.pop()/num);
                sign = s.charAt(i); 
            }
        }
        if (sign == '+') st.push(num);
        if (sign == '-') st.push(-num);
        if (sign == '*') st.push(st.pop()*num);
        if (sign == '/') st.push(st.pop()/num);        
        while (!st.isEmpty()) {
            res += st.pop();
        }
        return res;
    }
}

// Using PreSum. O(n) time, O(1) space.
class Solution {
    public int calculate(String s) {
        if (s == null || s.length() == 0) return 0;
        int res = 0;
        int multi = 0;
        char sign = '+';
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            if (Character.isDigit(s.charAt(i))) {
                num = s.charAt(i) - '0';
                while (i+1 < s.length() && Character.isDigit(s.charAt(i+1))) {
                    num = s.charAt(i+1) - '0' + num * 10;
                    i++;
                }
            }
            else if (s.charAt(i) != ' ') {
                if (sign == '+') {
                    res += num;
                    multi = num;
                }
                if (sign == '-') {
                    res -= num;
                    multi = -num;
                }
                if (sign == '*') {
                    res -= multi;
                    res += multi*num;
                    multi = multi*num;
                }
                if (sign == '/') {
                    res -= multi;
                    res += multi/num;
                    multi = multi/num;
                }
                sign = s.charAt(i); 
            }
        }
        if (sign == '+') res += num;
        if (sign == '-') res -= num;
        if (sign == '*') {
            res -= multi;
            res += multi*num;            
        }
        if (sign == '/') {
            res -= multi;
            res += multi/num;            
        }       
        return res;
    }
}