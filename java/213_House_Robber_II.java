class Solution {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int rob1 = nums[0], notrob1 = 0, rob2 = 0, notrob2 = 0;
        for (int i = 1; i < nums.length; i++) {
            int prev1 = Math.max(rob1, notrob1);
            rob1 = notrob1 + nums[i];
            notrob1 = prev1;
            int prev2 = Math.max(rob2, notrob2);
            rob2 = notrob2 + nums[i];
            notrob2 = prev2;
        }
        return Math.max(notrob1, Math.max(rob2, notrob2));
    }
}