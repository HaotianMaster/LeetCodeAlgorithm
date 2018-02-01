// Brute force. AC. O(n^2) time, O(1) space.
class Solution {
    public int maxSubArrayLen(int[] nums, int k) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int sum = 0;

        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                sum += nums[j];
                if (sum == k) {
                    max = Math.max(max, j-i+1);
                }
            }
            sum = 0;
        }
        return max;
    }
}