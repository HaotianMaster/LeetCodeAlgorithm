/**
 * O(nlogn) time, O(1) space solution using binary search with range. 
 */
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        while (low<high) {
            int mid = (low+high)/2;
            int count = 0;
            for (int num:nums) {
                if (num<=mid && num>=low) count++;
            }
            if (count>mid-low+1) high = mid;
            else low = mid+1;
        }
        return low;
    }
}
// Same
class Solution {
    public int findDuplicate(int[] nums) {
        int low = 1;
        int high = nums.length-1;
        while (low<high) {
            int mid = (low+high)/2;
            int count = 0;
            for (int num:nums) {
                if (num<=mid) count++;
            }
            if (count>mid) high = mid;
            else low = mid+1;
        }
        return low;
    }
}
