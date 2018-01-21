// Sorting first, O(nlogn) time, O(1) space

class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        Arrays.sort(nums);
        int longest = 1;
        int curr = 1;
        for (int i=1; i<nums.length; i++) {
            if (nums[i]!=nums[i-1]) {
                if (nums[i]-nums[i-1]==1) {
                    curr++;
                    longest = Math.max(longest, curr);
                }
                else {
                    curr = 1;
                }                
            }
        }
        return longest;
    }
}
// HashSet. O(n) time, O(n) space.
class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums==null || nums.length==0) return 0;
        Set<Integer> num_set = new HashSet<>();
        for (int num:nums) num_set.add(num);  
        int longest = 1;
        for (int num:nums) {
            if (!num_set.contains(num-1)) {
                int curr = 1;
                while (num_set.contains(num+1)) {
                    curr++;                    
                    num++;
                }
                longest = Math.max(longest, curr);
            }
        }
        return longest;
    }
}