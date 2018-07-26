//Obviously this question can be solved within O(n) time by traversing the whole array 
//and looking for the position i that satisfies nums[i] < nums[i - 1].

class Solution {
    public int findMin(int[] nums) {
        if (nums==null||nums.length==0) {
            return 0;
        }
        if (nums.length==1) return nums[0];
        int prev = nums[0];
        for (int i=1; i<nums.length; i++) {
            if (nums[i]<prev) return nums[i];
            prev = nums[i];
        }
        return nums[0];
    }
}

//By take sorted into consideration, we can use a slightly changed binary search way 
//and reduce the runtime to O(logn).
class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int left = 0, right = nums.length - 1;
        
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;

            if (mid > 0 && nums[mid] < nums[mid - 1]) {
                return nums[mid];
            }
            else if (nums[mid] > nums[right]) {
                left = mid;
            }
            else if (nums[mid] < nums[right]) {
                right = mid;
            }
        }
        return nums[left] < nums[right] ? nums[left] : nums[right];          
    }
}
