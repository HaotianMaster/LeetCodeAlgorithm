class Solution {
    public List<List<Integer>> getFactors(int n) {
        List<List<Integer>> res = new ArrayList<>();
        if (n <= 1) return res;
        getFactorsHelper(res, new ArrayList<>(), n, 2);
        return res;
    }
    public void getFactorsHelper(List<List<Integer>> res, List<Integer> list, int n, int start) {
        if (n == 1 && list.size() > 1) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i=start; i<=n; i++) {
            if (n%i == 0) {
                list.add(i);
                getFactorsHelper(res, list, n/i, i);
                list.remove(list.size()-1);
            }           
        }
    }
}