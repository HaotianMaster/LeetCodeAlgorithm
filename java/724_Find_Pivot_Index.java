class Solution {
    public int pivotIndex(int[] nums) {
        if (nums == null || nums.length == 0) return -1;
        int sum = 0, left_sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        for (int i = 0; i < nums.length; i++) {
            if (i != 0) left_sum += nums[i - 1];
            if (left_sum == sum - left_sum - nums[i]) return i;
        }
        return -1;
    }
}