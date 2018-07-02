class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        Arrays.sort(nums);
        boolean[] memory = new boolean[nums.length];
        permuteUniqueHelper(nums, memory, 0, new ArrayList<Integer>(), res);
        return res;
    }
    public void permuteUniqueHelper(int[] nums, boolean[] memory, int length, List<Integer>list, List<List<Integer>> res) {
        if (length == nums.length) {
            res.add(new ArrayList<Integer>(list));
            return;
        }
        int prev = nums[0] - 1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != prev && !memory[i]) {
                prev = nums[i];
                list.add(nums[i]);
                memory[i] = true;
                permuteUniqueHelper(nums, memory, length + 1, list, res);
                memory[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }
}