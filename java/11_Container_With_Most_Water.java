// (Two Pointer Approach) [Accepted]

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int upleft = height[left];
        int right = height.length-1;
        int upright = height[height.length-1];
        int wide = height.length-1;
        int max = 0;
        while (left!=right) {
	    wide = wide-1;
            if (upleft<=upright) {
                max = Math.max(max, upleft*wide);
                left = left+1;
                upleft = height[left];
            }
            else {
                max = Math.max(max, upright*wide);
                right = right-1;
                upright = height[right];
            }
        }
        return max;
    }
}
