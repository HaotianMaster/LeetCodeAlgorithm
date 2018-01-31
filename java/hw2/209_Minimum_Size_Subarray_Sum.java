// Brute force.  Time Limit Exceeded. 0(n^3) time, O(1) space.
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            for (int j=i; j<nums.length; j++) {
                int sum = 0;
                for (int k=i; k<=j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    min = Math.min(min, j-i+1);
                    break; //Found the smallest subarray with sum>=s starting with index i, hence move to next index
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

// Better brute force. Accepted. 0(n^2) time, O(1) space.
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        for (int i=0; i<nums.length; i++) {
            int sum = 0;
            for (int k=i; k<nums.length; k++) {
                sum += nums[k];
                if (sum >= s) {
                    min = Math.min(min, k-i+1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}
// Another accepted brute force. 0(n^2) time, O(n) space.
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i=1; i<nums.length; i++) {
            sum[i] = sum[i-1]+nums[i];
        }
        for (int i=0; i<nums.length; i++) {
            int mSum = 0;
            for (int j=i; j<nums.length; j++) {
                mSum = sum[j]-sum[i]+nums[i];
                if (mSum >= s) {
                    min = Math.min(min, j-i+1);
                    break;
                }
            }
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}

// Binary search. 0(nlogn) time, O(n) space.
// Since all the numbers are positive, 
// then their cumulative sum must be in the increasing order. 
// Thus we can perform a binary search on the cumulative sum array. 
class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int[] sum = new int[nums.length];
        sum[0] = nums[0];

        for (int i=1; i<nums.length; i++) {
            sum[i] = sum[i-1]+nums[i];
        }
        
        for (int i=0; i<nums.length; i++) {
            int mSum = 0;
            //s <= sum[j]-sum[i]+nums[i]
            int target = s+sum[i]-nums[i];
            int j = binarySearch(sum, target, i, sum.length-1);
            if (j == nums.length) break;
            min = Math.min(min, j-i+1);
        }
        
        return min == Integer.MAX_VALUE ? 0 : min;
    }
    
    public int binarySearch(int[] sum, int target, int low, int high) {
        while (low <= high) {
            int mid = low + (high-low)/2;
            if (sum[mid] == target) return mid;
            else if (sum[mid] > target) {
                high = mid-1;
            }
            else low = mid+1;
        }
        return low;
    }
}

/**
 * 2 pointers sliding window solution
 * In order to make it a O(n) solution, we need to move 2 pointers both in one round. 
 * Sliding window templete. 
 * O(n) time
 * O(1) space
 */

class Solution {
    public int minSubArrayLen(int s, int[] nums) {
        if (nums == null | nums.length == 0) return 0;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        int i = 0;
        for (int j=0; j<nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                min = Math.min(min, j-i+1);
                sum -= nums[i++];
            }
        }       
        return min == Integer.MAX_VALUE ? 0 : min;
    }
}














