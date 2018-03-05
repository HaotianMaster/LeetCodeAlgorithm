// BFS. 
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        Deque<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<String>();     
        queue.offer(s);
        boolean found = false;
        while (!queue.isEmpty()) {
            String curr = queue.poll();
            if (isValid(curr)) {
                res.add(curr);
                found = true;
            }
            if (found) continue;
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) != '(' && curr.charAt(i) != ')') continue;
                String tmp = curr.substring(0, i) + curr.substring(i + 1);
                if (!visited.contains(tmp)) {
                    queue.offer(tmp);
                    visited.add(tmp);
                }                          
            } 
        }
        return res;
    }

    public boolean isValid(String s) {
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != '(' && s.charAt(i) != ')') continue;
            if (s.charAt(i) == '(') count++;
            if (s.charAt(i) == ')') count--;
            if (count < 0) return false;
        }
        return count == 0;
    }
}


// DFS
class Solution {
    public List<String> removeInvalidParentheses(String s) {
        List<String> res = new ArrayList<>();
        if (s == null || s.length() == 0) {
            res.add("");
            return res;
        }
        helper(res, s, 0, 0, new char[]{'(', ')'});
        return res;
    }
    
    public void helper(List<String> res, String s, int last_i, int last_j, char[] pair) {
        for (int count = 0, i = last_i; i < s.length(); i++) {
            if (s.charAt(i) == pair[0]) count++;
            if (s.charAt(i) == pair[1]) count--;
            if (count >= 0) continue;
            //count < 0, need to remove one right parenthesis
            for (int j = last_j; j <= i; j++) {
                if (s.charAt(j) == pair[1] && (j == last_j || s.charAt(j - 1) != pair[1])) {
                    helper(res, s.substring(0, j) + s.substring(j + 1), i, j, pair);
                }
            }
            return;
        }
        String reversed = new StringBuilder(s).reverse().toString();
        if (pair[0] == '(') {
            helper(res, reversed, 0, 0, new char[]{')', '('});
        }
        else {
            res.add(reversed);
        }
    } 
}
