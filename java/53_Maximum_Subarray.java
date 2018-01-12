// Greedy

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        int sum = nums[0];
        int max = nums[0];
        for (int i=0; i<nums.length-1; i++) {
            if (sum<0) {
                sum = nums[i+1];
                max = Math.max(max, sum);
            }
            else {
                sum = sum+nums[i+1];
                max = Math.max(max, sum);
            }
        }
        return max;
    }
}

// Divide and Conquer

class Solution {
    public int maxSubArray(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        return maximumSubArray(nums, 0, nums.length-1);
    }
    private int maximumSubArray(int[] array, int low, int high) {
        if (low==high) {
            return array[low];
        }
        int mid = (low+high)/2;
        int maxMid = maxMidSubArray(array, mid, low, high);
        int maxLeft = maximumSubArray(array, low, mid);
        int maxRight = maximumSubArray(array, mid+1, high);
        if (maxMid>=maxLeft && maxMid>=maxRight) {
            return maxMid;
        }
        else if (maxLeft>=maxMid && maxLeft>=maxRight) {
            return maxLeft;
        }
        else {
            return maxRight;
        }
    }
    private int maxMidSubArray(int[] array, int mid, int low, int high) {
        int maxright = Integer.MIN_VALUE;
        int curr = 0;
        for (int i=mid+1; i<=high; i++) {
            curr = curr+array[i];
            maxright = Math.max(maxright, curr);
        }
        int maxleft = Integer.MIN_VALUE;
        curr = 0;
        for (int i=mid; i>=low; i--) {
            curr= curr+array[i];
            maxleft = Math.max(maxleft, curr);
        }
        int maxmid = maxright+maxleft;
        return maxmid;
    }
}
