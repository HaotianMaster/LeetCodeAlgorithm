class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        if (s == null || s.length() == 0) return res;
        partitionHelper(res, new ArrayList<>(), s, 0);
        return res;
    }
    
    public void partitionHelper(List<List<String>> res, List<String> list, String s, int currIndex) {
        if (currIndex == s.length()) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=currIndex; i<s.length(); i++) {
            if (isPalindrome(s, currIndex, i)) {
                list.add(s.substring(currIndex, i+1));
                partitionHelper(res, list, s, i+1);
                list.remove(list.size()-1);
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