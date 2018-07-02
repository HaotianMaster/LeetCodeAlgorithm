class Solution {
    public int[] maxSumOfThreeSubarrays(int[] nums, int k) {
        //W is an array of sums of slide windows.
        //Each window has length of k.
        int[] W = new int[nums.length - k + 1];
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (i >= k) sum -= nums[i - k];
            if (i >= k-1) W[i - k + 1] = sum;
        }
        
        // We have left, mid, right.
        // Generate the best left index first, given nums[0 : i + k]. 
        int[] left = new int[W.length];
        int best = 0;
        for (int i = 0; i < W.length; i++) {
            if (W[i] > W[best]) best = i;
            left[i] = best;
        }
        
        // Generate the best right index first, given nums[i - k : ]. 
        int[] right = new int[W.length];
        best = W.length - 1;
        for (int i = W.length - 1; i >= 0; i--) {
            if (W[i] > W[best]) best = i;
            right[i] = best;
        }
        
        // Iterate possible mid index and find the best result.
        int[] res = new int[] {-1, -1, -1};
        for (int m = k; m < W.length - k; m++) {
            int l = left[m - k], r = right[m + k];
            if (res[0] == -1 || W[l] + W[m] + W[r] > W[res[0]] + W[res[1]] + W[res[2]]) {
                res[0] = l;
                res[1] = m;
                res[2] = r;
            }
        }
        return res;
    }
}