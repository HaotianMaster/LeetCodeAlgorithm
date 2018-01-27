// One pass. O(n) time.
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target == 0 || target < nums[0]) return 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i] == target) return i;
            else if (i != 0 && nums[i-1] < target && nums[i] > target) return i;
        }
        return nums.length;
    }
}
// As long as you have a sorted array, think about binary search.
// O(logn) time.
class Solution {
    public int searchInsert(int[] nums, int target) {
        if (target == 0 || target < nums[0]) return 0;
        int left = 0;
        int right = nums.length-1;
        while (left <= right) {
            int mid = (right-left)/2+left;
            if (nums[mid] == target) return mid;
            else if (target < nums[mid]) right = mid-1;
            else left = mid+1;
        }
        return left;
    }
}