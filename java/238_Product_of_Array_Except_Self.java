// Solve it without division and in O(n) time.
// O(n) time, O(n) space. This DP actually. Two pass.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] leftmultiply = new int[nums.length];
        int[] rightmultiply = new int[nums.length];
        int[] output = new int[nums.length];
        leftmultiply[0] = 1;
        rightmultiply[nums.length-1] = 1;
        for (int i=1; i<nums.length; i++) {
            leftmultiply[i] = leftmultiply[i-1]*nums[i-1];
        }
        for (int i=nums.length-2; i>=0; i--) {
            rightmultiply[i] = rightmultiply[i+1]*nums[i+1];
        }
        for (int i=0; i<nums.length; i++) {
            output[i] = leftmultiply[i]*rightmultiply[i];
        }
        return output;
    }
}

// O(n) time, O(1) space. This DP actually. Two pass.

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] output = new int[nums.length];
        output[0] = 1;
        for (int i=1; i<nums.length; i++) {
            output[i] = output[i-1]*nums[i-1];
        }
        int right = 1;
        for (int i=nums.length-2; i>=0; i--) {
            right = right*nums[i+1];
            output[i] = output[i]*right;
        }
        return output;
    }
}
