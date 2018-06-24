class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int multiply = 1;
        int l = 0, count = 0;
        for (int r = 0; r < nums.length; r++) {
            multiply *= nums[r];
            while (l <= r && multiply >= k) {
                multiply /= nums[l++];
            }
            count += r - l + 1;
        }
        return count;
    }
}