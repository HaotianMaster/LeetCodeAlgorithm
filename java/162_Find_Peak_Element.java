// Iterative ninary search
class Solution {
    public int findPeakElement(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid;
            }
            else {
                left = mid + 1;
            }
        }
        return left;
    }
}

// Recursive binary search
class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums, 0, nums.length - 1);
    }
    public int binarySearch(int[] nums, int left, int right) {
        if (left >= right) return left;
        int mid = (left + right) / 2;
        int peak;
        if (nums[mid] > nums[mid + 1]) {
            peak = binarySearch(nums, left, mid);
        }
        else {
            peak = binarySearch(nums, mid + 1, right);
        }
        return peak;
    }
}