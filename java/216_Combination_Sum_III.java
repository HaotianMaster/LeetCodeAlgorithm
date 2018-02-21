class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (k < 1 || n < 1 || k*9 < n) return res;
        combinationHelper(k, n, res, new ArrayList<>(), 1);
        return res;
    }
    public void combinationHelper(int k, int n, List<List<Integer>> res, List<Integer> list, int start) {
        if (list.size() > k) return;
        if (list.size() == k && n == 0) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=start; i<=9; i++) {
            if (i <= n) {
                list.add(i);
                combinationHelper(k, n-i, res, list, i+1);
                list.remove(list.size()-1);
            }
        }
    }
}