// 1D-DP, O(n^2) time.
// dp[i] represents the length of the longest increasing subsequence possible considering the array elements upto the i^{th} index only, by necessarily including the i^{th} element. 
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]); 
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}

// binary search, O(nlogn) time.
// dp array stores the increasing subsequence formed by including the currently encountered element. 
class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        int length = 0;
        for (int num : nums) {
            // binary search 
            int left = 0, right = length, mid = 0;
            // 精华, find the right position to replace
            while (left < right) {
                mid = left + (right - left) / 2;
                if (dp[mid] < num) left = mid + 1;
                else right = mid;
            }
            // left is the right position to "replace" in dp array
            dp[left] = num;
            if (left == length) length++;
        }
        return length;
    }
}