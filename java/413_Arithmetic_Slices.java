// Brute Force
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        if (A == null || A.length < 3) return 0;
        int count = 0;
        for (int i = 0; i < A.length - 2; i++) {
            int diff = A[i+1] - A[i];
            for (int j = i + 2; j < A.length; j++) {
                if (A[j] - A[j-1] == diff) count++;
                else break;
            }
        }
        return count;
    }
}

// Recursion
// Time complexity : O(n). The recursive function is called at most n-2 times.
// Space complexity : O(n). The depth of the recursion tree goes upto n-2.
class Solution {
    int res = 0;
    public int numberOfArithmeticSlices(int[] A) {
        helper(A, A.length - 1);
        return res;
    }
    public int helper(int[] A, int i) {
        if (i < 2) return 0;
        int curr = 0;
        if (A[i] - A[i-1] == A[i-1] - A[i-2]) {
            curr = 1 + helper(A, i-1);
            res += curr;
        }
        else {
            helper(A, i-1);
        }
        return curr;
    }
}

// DP
// Time complexity : O(n). We traverse over the given A array with n elements once only.
// Space complexity : O(n). 1-D dp of size n is used.
class Solution {
    public int numberOfArithmeticSlices(int[] A) {
        int[] dp = new int[A.length];
        int sum = 0;
        for (int i = 2; i < dp.length; i++) {
            if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                dp[i] = 1 + dp[i - 1];
                sum += dp[i];
            }
        }
        return sum;
    }
}