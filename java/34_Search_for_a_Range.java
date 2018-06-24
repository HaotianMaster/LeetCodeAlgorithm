class Solution {
    public int[] searchRange(int[] nums, int target){
        int[] res = new int[]{-1, -1};
        if (nums == null || nums.length == 0) return res;
        int st_point = -1, end_point = -1;
        int left = 0, right = nums.length - 1;
        //find the start point
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] >= target) right = mid;
            else left = mid;
        }
        if (nums[left] == target) st_point = left;
        else if (nums[right] == target) st_point = right;
        if (st_point == -1) return res;
        
        left = 0; 
        right = nums.length - 1;
        //find the end point   
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > target) right = mid;
            else left = mid;
        }
        if (nums[right] == target) end_point = right;
        else if (nums[left] == target) end_point = left;
        
        res[0] = st_point;
        res[1] = end_point;
        return res;
    }
}