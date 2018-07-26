// Three pointers and four regions.
// The left region of i is all 0s.
// The region between i and j is all 1s.
// The region between j and k is unknown.
// The right region of k is all 2s.

class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) return;
        int i = 0, j = 0, k = nums.length - 1;
        while (j <= k) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
                j++;
            }
            else if (nums[j] == 1) {
                j++;
            }
            else {
                swap(nums, j, k);
                k--;
            }
        }
    }
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}