// Same with 300th leetcode, binary search. 
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int[] dp = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            int left = 0, right = length, mid = 0;
            while (left < right) {
                mid = left + (right - left) / 2;
                if (dp[mid] < num) left = mid + 1;
                else right = mid;
            }
            dp[left] = num;
            if (left == length) length++;
            if (length >= 3) return true;
        }
        return false;
    }
}

// O(n)
class Solution {
    public boolean increasingTriplet(int[] nums) {
        if (nums.length < 3) return false;
        int small = Integer.MAX_VALUE, smaller = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num <= smaller) {
                smaller = num;
            }
            else if (num <= small) {
                small = num;
            }
            else {
                return true;
            }
        }
        return false;
    }
}