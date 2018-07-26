class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res  = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        subsetsHelper(nums, res, new ArrayList<Integer>(), 0);
        return res;
    }
    public void subsetsHelper(int[] nums, List<List<Integer>> res, List<Integer> list, int idx) {
        res.add(new ArrayList<Integer>(list));
        for (int i = idx; i < nums.length; i++) {
            list.add(nums[i]);
            subsetsHelper(nums, res, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}