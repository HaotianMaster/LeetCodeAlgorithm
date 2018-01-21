//My solution. First, count the times of repeatibility and replace the 
//repeated value with Integer.MIN_VALUE. Second, move all the Integer.MIN_VALUE
//to the back and return the non-Integer.MIN_VALUE elements. 

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length<2) return nums.length;
        int count = 0;
        for (int i=0; i<nums.length-1; i++) {
            if (nums[i]==nums[i+1]) {
                nums[i] = Integer.MIN_VALUE;
                count++;  
            }
        }
        int lastnonzero = 0;
        int temp = 0;
        for (int i=0; i<nums.length; i++) {
            if (nums[i]!=Integer.MIN_VALUE) {
                temp = nums[lastnonzero];
                nums[lastnonzero++] = nums[i];
                nums[i] = temp;
            } 
        }
        return nums.length-count;
    }
}

//(Two Pointers) [Accepted]

class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return 1;
        int j = 1;
        for (int i = 1; i<nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                nums[j] = nums[i];
                j++;
            }
        }
        return j;
    }
}

