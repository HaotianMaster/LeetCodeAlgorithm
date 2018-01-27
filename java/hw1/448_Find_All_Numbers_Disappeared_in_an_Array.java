//Iterate the array. If we see a number, mark at the position of number-1. 
// O(n) time, O(1) space.
class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if (nums==null || nums.length==0) return new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for (int i=0; i<nums.length; i++) {
            int targetposition = Math.abs(nums[i])-1;
            nums[targetposition] = -Math.abs(nums[targetposition]);
        }
        for (int i=0; i<nums.length; i++) {
            if (nums[i]>0) {
                list.add(i+1);
            }
        }
        return list;
    }
}