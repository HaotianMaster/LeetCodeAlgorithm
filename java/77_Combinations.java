class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n < k) return res;
        combineHelper(n, k, res, new ArrayList<>(), 0, 1);
        return res;
    }
    public void combineHelper(int n, int k, List<List<Integer>> res, List<Integer> list, int length, int currInt) {
        if (length == k) {
            res.add(new ArrayList<>(list));
            return;
        }
        for (int i=currInt; i<=n; i++) {
            list.add(i);
            combineHelper(n, k, res, list, length+1, i+1);
            list.remove(list.size()-1);
        }
    }
}