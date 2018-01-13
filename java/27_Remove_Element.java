class Solution {
    public int removeElement(int[] nums, int val) {
        int lastnonval = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=val) {
                nums[lastnonval++] = nums[i];
            }
        }
        return lastnonval;
    }
}
