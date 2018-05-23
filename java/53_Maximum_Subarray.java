// Greedy/DP

class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = sum;
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(nums[i], nums[i]+sum);
            max = Math.max(max, sum);
        }
        return max;
    }
}

// Divide and Conquer

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        return maximumSubArray(nums, 0, nums.length - 1);
    }
    public int maximumSubArray(int[] nums, int low, int high) {
        if (low == high) return nums[low];
        int mid = (low + high) / 2;
        int maxmid = maximumSubArrayAtMid(nums, mid, low, high);
        int maxLeft = maximumSubArray(nums, low, mid);
        int maxRight = maximumSubArray(nums, mid + 1, high);
        return Math.max(maxmid, Math.max(maxLeft, maxRight));
    }
    public int maximumSubArrayAtMid(int[] nums, int mid, int low, int high) {
        int maxL = Integer.MIN_VALUE, curr = 0, maxR = Integer.MIN_VALUE;
        for (int i = mid; i >= low; i--) {
            curr += nums[i];
            maxL = Math.max(curr, maxL);
        }
        curr = 0;
        for (int i = mid + 1; i <= high; i++) {
            curr += nums[i];
            maxR = Math.max(curr, maxR);
        }   
        return maxL + maxR;
    }
}
