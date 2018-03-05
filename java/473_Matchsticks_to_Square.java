class Solution {
    public boolean makesquare(int[] nums) {
        if (nums == null || nums.length < 4) return false;
        int sum = 0;
        for (int num : nums) sum += num;
        if (sum % 4 != 0) return false;
        Arrays.sort(nums);
        return makesquareHelper(nums, new int[4], nums.length-1, sum / 4);
    }
    
    public boolean makesquareHelper(int[] nums, int[] sums, int pos, int target) {
        if (pos == -1) {
            if (sums[0] == target && sums[1] == target && sums[2] == target) {
                return true;
            }
            return false;
        }
        
        for (int i = 0; i < 4; i++) {
            if (sums[i] + nums[pos] <= target) {
                sums[i] += nums[pos];
                if (makesquareHelper(nums, sums, pos - 1, target)) return true;
                sums[i] -= nums[pos];   
            }
        }
        
        return false;        
    }
}