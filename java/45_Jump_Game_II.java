class Solution {
    public int jump(int[] nums) {
        int step = 0, curr_most = 0, next_most= 0;
        for (int i = 0; i < nums.length && curr_most < nums.length - 1; i++) {
            next_most = Math.max(next_most, i + nums[i]);
            if (i == curr_most) {
                curr_most = next_most;
                step++;
            }
        }
        return step;
    }
}