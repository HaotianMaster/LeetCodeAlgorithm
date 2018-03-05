// Direct DFS, implmentation 1. 
class Solution {
    int res = 0;
    public int findTargetSumWays(int[] nums, int S) {
        DFS(nums, S, 0, 0);
        return res;
    }
    public void DFS(int[] nums, int S, int pos, int val) {
        if (pos == nums.length) {
            if (S == val)
                res++;
            return;
        }
        DFS(nums, S, pos+1, val+nums[pos]);
        DFS(nums, S, pos+1, val-nums[pos]);            
    }
}
// Direct DFS, implmentation 2. 
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        return calculate(nums, 0, 0, S);
    }
    public int calculate(int[] nums, int pos, int sum, int S) {
        if (pos == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            int add = calculate(nums, pos + 1, sum + nums[pos], S);
            int subtract = calculate(nums, pos + 1, sum - nums[pos], S);
            return add + subtract;
        }
    }
}

// DFS with memorization. 
public class Solution {
    public int findTargetSumWays(int[] nums, int S) {
        int[][] memo = new int[nums.length][2001];
        for (int[] row : memo) Arrays.fill(row, Integer.MIN_VALUE);
        return calculate(nums, 0, 0, S, memo);
    }
    public int calculate(int[] nums, int pos, int sum, int S, int[][] memo) {
        if (pos == nums.length) {
            if (sum == S)
                return 1;
            else
                return 0;
        } else {
            if (memo[pos][sum+1000] != Integer.MIN_VALUE) return memo[pos][sum+1000];
            int add = calculate(nums, pos + 1, sum + nums[pos], S, memo);
            int subtract = calculate(nums, pos + 1, sum - nums[pos], S, memo);
            memo[pos][sum+1000] = add + subtract;
            return memo[pos][sum+1000];
        }
    }
}


