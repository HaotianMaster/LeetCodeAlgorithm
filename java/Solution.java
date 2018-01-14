import java.util.*;
class Solution {
    public List<String> summaryRanges(int[] nums) {
        List<String> summary = new ArrayList<>();
        if (nums == null || nums.length == 0) return summary;

        int start = nums[0];
        int end = nums[0];
        for (int i=1; i<nums.length; i++) {
	    System.out.println(i);
            if (nums[i]-end==1) {
                end = nums[i];
            }
	    System.out.println(nums[i]);
	    System.out.println(end);
	    System.out.println(nums[i]-end);
            if (nums[i]-end>1) {
                System.out.println(323);
        	System.out.println(32323);
            }
        }

        if (start==end) {
            summary.add(start + "");
        }
        else {
            summary.add(start + "->" + end);
        }
        return summary;
    }
    public static void main(String[] args) {
        int[] nums = {-2147483648,-2147483647,2147483647};
	Solution sol = new Solution();
	sol.summaryRanges(nums);
        
    }
}
