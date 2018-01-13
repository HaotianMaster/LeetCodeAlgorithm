class Solution {
    public int rob(int[] nums) {
        if (nums.length==0) {
            return 0;
        }
        if (nums.length==1) {
            return nums[0];
        }
        if (nums.length==2) {
            return Math.max(nums[0], nums[1]);
        }
        int max = 0;
        int temp = 0;
        int prevmax = Math.max(nums[0], nums[1]);
        int prevprevmax = nums[0];
        for (int i=2; i< nums.length; i++) {
            if (prevprevmax+nums[i]>prevmax) {
                max = prevprevmax+nums[i];
                temp = prevmax;
                prevprevmax = prevmax;
                prevmax = max;
            }
            else {
                max = prevmax;
                temp = prevmax;
                prevprevmax = prevmax;
                prevmax = max;
            }
        }
        return max;
    }
}
