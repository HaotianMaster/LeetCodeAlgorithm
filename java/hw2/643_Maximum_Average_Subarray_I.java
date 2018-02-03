// Sliding windows. O(n) time, O(1) space. 
class Solution {
    public double findMaxAverage(int[] nums, int k) {
        if (nums == null || nums.length<k) return 0.0;
        double curr = 0.0;
        for (int i=0; i<k; i++) curr += nums[i];
        double max = -Double.MAX_VALUE;
        max = Math.max(max, curr/k);
        for (int i=k; i<nums.length; i++) {
            curr = curr+nums[i]-nums[i-k];
            max = Math.max(max, curr/k);
        }
        return max;
    }
}