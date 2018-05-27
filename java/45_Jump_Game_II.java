class Solution {
    public int jump(int[] nums) {
        int step = 0, currmax = 0, nextmax = 0;
        for (int i = 0; i < nums.length && currmax < nums.length - 1; i++) {
            nextmax = Math.max(nextmax, i + nums[i]);
            if (i == currmax) {
                currmax = nextmax;
                step++;
            }
        }
        return step;
    }
}