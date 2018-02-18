class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        if (n == 0) return list;
        parenthesisHelper("", 0, 0, n, list);
        return list;
    }
    public void parenthesisHelper(String curr, int left, int right, int n, List<String> list) {
        if (right == n) {
            list.add(curr);
            return;
        }
        if (left < n) {
            parenthesisHelper(curr+"(", left+1, right, n, list);
        }
        if (right < left) {
            parenthesisHelper(curr+")", left, right+1, n, list);
        }
    }
}