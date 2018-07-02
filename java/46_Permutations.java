class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        boolean[] memory = new boolean[nums.length];
        permuteHelper(nums, memory, 0, new ArrayList<Integer>(), res);
        return res;
    }
    public void permuteHelper(int[] nums, boolean[] memory, int length, List<Integer>list, List<List<Integer>> res) {
        if (length == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!memory[i]) {
                list.add(nums[i]);
                memory[i] = true;
                permuteHelper(nums, memory, length + 1, list, res);
                memory[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}