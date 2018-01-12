import java.util.*;
class Solution {
    public int trap(int[] A) {
        if (A==null) return 0;
        Stack<Integer> s = new Stack<Integer>();
        int i = 0, maxWater = 0, maxBotWater = 0;
        while (i < A.length){
            if (s.isEmpty() || A[i]<=A[s.peek()]){
                s.push(i++);
            }
            else {
                int bot = s.pop();
                maxBotWater = s.isEmpty()? // empty means no il
                0:(Math.min(A[s.peek()],A[i])-A[bot])*(i-s.peek()-1);
                maxWater += maxBotWater;
            }
        }
        return maxWater;
    }
    public static void main(String[] args) {
        int[] nums = {1,0,0,1,2};
	Solution sol = new Solution();
	int test = sol.trap(nums);
        System.out.println(test);
    }
}
