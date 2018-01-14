// Solution1: Using sum

class Solution {
    public int missingNumber(int[] nums) {
        int expect = nums.length*(nums.length+1)/2;
        int actual = 0;
        for (int i=0; i<nums.length; i++) {
            actual += nums[i];
        }
        return expect-actual;
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
