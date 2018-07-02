// HashSet. O(n) time, O(n) space.
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums == null || nums.length == 0) return 1;
        Set<Integer> num_set = new HashSet<>();
        for (int num : nums) num_set.add(num);
        for (int curr = 1; curr <= nums.length; curr++) {
            if (!num_set.contains(curr)) return curr;
        }
        return nums.length + 1;        
    }
}
// O(n) time, O(1) space.
// Change all the non-positive number to max.
// Record in place. 
class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums==null || nums.length==0) return 1;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]<=0) nums[i] = Integer.MAX_VALUE;
        }
        for (int i=0; i<nums.length; i++) {
            int num = Math.abs(nums[i]);
            if (num<=nums.length) {
                nums[num-1]=-Math.abs(nums[num-1]);
            }           
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0) return i+1;
        }
        return nums.length+1;
    }
}

/** 3,4,-1,1
 *  -1,4,3,1
 *  -1,1,3,4
 *  1,-1,3,4
 *  Swap. O(n) time, O(1) space.
 */

class Solution {
    public int firstMissingPositive(int[] nums) {
        if (nums==null || nums.length==0) return 1;

        for (int i=0; i<nums.length; i++) {
            while (nums[i]>0 && nums[i]<=nums.length && nums[nums[i]-1]!=nums[i])  
                swap(nums, nums[i]-1, i);
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=i+1) return i+1;
        }
        return nums.length+1;
    }
    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}


