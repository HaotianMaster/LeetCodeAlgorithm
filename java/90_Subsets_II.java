class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, res, new ArrayList<>(), 0);
        return res;
    }
    public void subsetsWithDupHelper(int[] nums, List<List<Integer>> res, List<Integer> list, int start) {
        res.add(new ArrayList<Integer>(list));
        if (start == nums.length) return;
        int prev = nums[start] - 1;
        for (int i = start; i < nums.length; i++) {
            if (nums[i] != prev) {
                list.add(nums[i]);
                subsetsWithDupHelper(nums, res, list, i + 1);
                list.remove(list.size() - 1);
                prev = nums[i];
            }
        }
    }
}