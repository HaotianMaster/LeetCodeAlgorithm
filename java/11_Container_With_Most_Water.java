// (Two Pointer Approach) [Accepted]

class Solution {
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int upleft = height[left], upright = height[right];
        int max = 0, wide = height.length;
        while (left != right) {
            wide--;
            if (upleft <= upright) {
                max = Math.max(max, upleft * wide);
                left++;
                upleft = height[left];
            }
            else {
                max = Math.max(max, upright * wide);
                right--;
                upright = height[right];                
            }
        }
        return max;
    }
}
