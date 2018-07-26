class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        char[] chars = s.toCharArray();
        helper(s, res, new ArrayList<String>(), 0);
        return res;
    }
    public void helper(String s, List<List<String>> res, List<String> list, int start) {
        if (start == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i = start; i < s.length(); i++) {
            if (isPalindrome(s, start, i)) {
                list.add(s.substring(start, i + 1));
                helper(s, res, list, i + 1);
                list.remove(list.size() - 1);
            }
        }
    }
    public boolean isPalindrome(String s, int low, int high) {
        if (low == high) return true;
        while (low <= high) {
            if (s.charAt(low) != s.charAt(high)) return false;
            low++; 
            high--;
        }
        return true;        
    }
}