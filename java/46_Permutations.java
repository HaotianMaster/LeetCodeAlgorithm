class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums == null || nums.length == 0) return res;
        permuteHelper(new ArrayList<>(), nums, 0, res);
        return res;
    }
    public void permuteHelper(List<Integer> curr, int[] nums, int currIndex, List<List<Integer>> res) {
        if (currIndex == nums.length) {
            res.add(new ArrayList<Integer>(curr));
            return;
        }
        for (int num:nums) {
            if (!curr.contains(num)) {
                curr.add(num);
                permuteHelper(curr, nums, currIndex+1, res);
                curr.remove(curr.size()-1);
            }
        }
    }
}