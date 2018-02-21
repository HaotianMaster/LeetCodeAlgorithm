class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) return result;
        List<Integer> list = new ArrayList<>();
        Arrays.sort(nums);
        subsetsHelper(nums, 0, result, list);
        return result;
    }
    public void subsetsHelper(int[] nums, int currIndex, List<List<Integer>> result, List<Integer> list) {
        result.add(new ArrayList<Integer>(list));
        int prev = nums[0]-1;
        for(int index=currIndex; index<nums.length; index++) {
            if (nums[index] != prev) {
                prev = nums[index];
                list.add(nums[index]);
                subsetsHelper(nums, index+1, result, list);
                list.remove(list.size()-1);                
            }
        }
    }    
}