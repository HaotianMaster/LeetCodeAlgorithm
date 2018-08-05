// O(log N) Binary search solution
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        int left = 0, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[left]) {
                if (target >= nums[left] && target <= nums[mid]) right = mid;
                else left = mid;
            }
            else if (nums[mid] < nums[left]) {
                if (target <= nums[right] && target >= nums[mid]) left = mid;
                else right = mid;
            }
        }
        if (nums[left] == target) return left;
        if (nums[right] == target) return right;
        return -1;
    }
}