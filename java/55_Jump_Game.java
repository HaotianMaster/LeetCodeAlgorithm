class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int last = nums.length - 1;
        for (int i = 0; i < nums.length; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= last) return true;
            if (i == maxReach) break;
        }
        return false;
    }
}

class Solution {
    public boolean canJump(int[] nums) {
        int maxReach = 0;
        int last = nums.length - 1;
        for (int i = 0; i < nums.length && i <= maxReach; i++) {
            maxReach = Math.max(maxReach, i + nums[i]);
            if (maxReach >= last) return true;
        }
        return false;
    }
}