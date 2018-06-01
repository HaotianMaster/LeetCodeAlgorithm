class Solution {
    public void wiggleSort(int[] nums) {
        for(int i = 0; i < nums.length; i++){
            if (i % 2 == 1){
               if (nums[i-1] > nums[i]) {
                   swap(nums, i-1, i);
               }
            }
            else if (i != 0 && nums[i-1] < nums[i]) {
                swap(nums, i-1, i);   
            }         
        }
    }
    public void swap(int[] nums, int x, int y){
          int tmp=nums[x];
          nums[x]=nums[y];
          nums[y]=tmp;
    }
}