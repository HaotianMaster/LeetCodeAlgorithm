class Solution {
    public List<String> findStrobogrammatic(int n) {
        return helper(n, n);
    }
    public List<String> helper(int curr_len, int len) {
        if (curr_len == 0) return new ArrayList<String>(Arrays.asList(""));
        if (curr_len == 1) return new ArrayList<String>(Arrays.asList("0", "1", "8"));
        
        List<String> res = new ArrayList<>();
        List<String> list = helper(curr_len - 2, len);
        for (int i = 0; i < list.size(); i++) {
            if (curr_len < len) res.add("0" + list.get(i) + "0");
            res.add("1" + list.get(i) + "1");
            res.add("6" + list.get(i) + "9");
            res.add("9" + list.get(i) + "6");
            res.add("8" + list.get(i) + "8");
        }
        return res;
    }
}