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
        if (nums==null||nums.length==0) {
            return 0;
        }
        if (nums.length==1 || nums[0]<=nums[nums.length-1]) return nums[0];
        int low = 0;
        int high = nums.length-1;
        while (low<high-1) {
            int mid = (low+high)/2;

            if (mid>0 && nums[mid]<nums[mid-1]) {
                return nums[mid];
            }
            else if (mid>0 && nums[mid]>nums[low]) {
                low = mid;
            }
            else if (mid>0 && nums[mid]<nums[high]) {
                high = mid;
            }
        }
        return nums[high];
    }
}
