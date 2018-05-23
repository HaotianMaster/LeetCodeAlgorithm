// DP, similar with longest increasing subsequence.
class Solution {
    public int findLongestChain(int[][] pairs) {       
        Comparator<int[]> myComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[0] - p2[0];
            }
        };  
        Arrays.sort(pairs, myComparator);
        int[] dp = new int[pairs.length];
        Arrays.fill(dp, 1);
        for (int i = 1; i < pairs.length; i++) {
            for (int j = 0; j < i; j++) {
                if (pairs[j][1] < pairs[i][0]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }           
        }
        return dp[pairs.length - 1];
    }
}

// Greedy, faster than DP. O(nlogn) time.
class Solution {
    public int findLongestChain(int[][] pairs) {       
        Comparator<int[]> myComparator = new Comparator<int[]>() {
            @Override
            public int compare(int[] p1, int[] p2) {
                return p1[1] - p2[1];
            }
        };  
        Arrays.sort(pairs, myComparator);
        int curr = Integer.MIN_VALUE, res = 0;
        for (int[] pair: pairs) if (curr < pair[0]) {
            curr = pair[1];
            res++;
        }
        return res;
    }
}