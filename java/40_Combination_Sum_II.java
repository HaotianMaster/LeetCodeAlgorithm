class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        if (candidates == null || candidates.length == 0 || target < 0) return res;
        Arrays.sort(candidates);
        combinationHelper(res, new ArrayList<>(), candidates, target, 0);
        return res;
    }
    public void combinationHelper(List<List<Integer>> res, List<Integer> list, int[] candidates, int target, int start) {
        if (target < 0) return;
        if (target == 0) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        int prev = -1;
        for (int i=start; i<candidates.length; i++) {
            if (candidates[i] != prev) {
                prev = candidates[i];
                list.add(candidates[i]);
                combinationHelper(res, list, candidates, target-candidates[i], i+1);
                list.remove(list.size()-1);
            }
        }
    }
}