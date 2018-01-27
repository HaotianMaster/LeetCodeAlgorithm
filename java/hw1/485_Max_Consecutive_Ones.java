class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (i == 0 && nums[i] == 1) count = 1;
            else if (i != 0 && nums[i] == 1 && nums[i-1] == 0) count = 1;
            else if (i != 0 && nums[i] == 1 && nums[i-1] == 1) count++;
            else count = 0;
            max = Math.max(max, count);
        }
        return max;
    }
}

class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int max = 0;
        int count = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == 1) count++;
            else count = 0;
            max = Math.max(max, count);
        }
        return max;
    }
}