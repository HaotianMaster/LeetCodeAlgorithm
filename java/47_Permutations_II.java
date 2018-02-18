class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        permuteHelper(new ArrayList<>(), nums, new boolean[nums.length], res);
        return res;
    }
    public void permuteHelper(List<Integer> curr, int[] nums, boolean[] used, List<List<Integer>> res) {
        if (curr.size() == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        int prev = nums[0]-1;
        for (int i=0; i<nums.length; i++) {
            if (used[i] == false && nums[i] != prev) {
                prev = nums[i];
                used[i] = true;
                curr.add(nums[i]);
                permuteHelper(curr, nums, used, res);
                curr.remove(curr.size()-1); 
                used[i] = false;
            }
        }
    }
}