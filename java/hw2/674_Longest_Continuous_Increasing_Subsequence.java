class Solution {
    public int findLengthOfLCIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 1; int curr = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i] > nums[i-1]) curr++;
            else {
                max = Math.max(max, curr);
                curr = 1;
            }
        }
        max = Math.max(max, curr);
        return max;
    }
}