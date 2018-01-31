// Solution1: Using sum

class Solution {
    public int missingNumber(int[] nums) {
        if (nums == null || nums.length == 0) return 0; 
        int n = nums.length;
        int desiredSum = (n+1)*n/2;
        int realSum = 0;
        for (int i=0; i<nums.length; i++) {
            realSum += nums[i];
        }
        return desiredSum-realSum;
    }
}

// Solution2: Using XOR

class Solution {
    public int missingNumber(int[] nums) {
        int missing = nums.length;
        for (int i=0; i<nums.length; i++) {
            missing ^= i^nums[i]; 
        }
        return missing;
    }
}
