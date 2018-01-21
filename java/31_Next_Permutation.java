// 1325476322 ---> 132562247

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums==null || nums.length==0 || nums.length==1) return;
        int replace = nums.length-2;
        while (replace>=0) {
            if (nums[replace] < nums[replace+1]) break;
            replace--;
        }
        if (replace<0) {
            Arrays.sort(nums);
            return;
        }
        int replacewith = replace+1;
        while (replacewith < nums.length && nums[replacewith] > nums[replace]) {
            replacewith++;
        }
        replacewith--;
        int temp = nums[replace];
        nums[replace] = nums[replacewith];
        nums[replacewith] = temp;
        Arrays.sort(nums, replace+1, nums.length);
    }
}