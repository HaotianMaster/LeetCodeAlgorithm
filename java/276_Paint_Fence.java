class Solution {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        if (n == 1) return k;
        // same[i] means the ith post has the same color with the (i-1)th post.
        int[] same = new int[n];
        // diff[i] means the ith post has a different color with the (i-1)th post.
        int[] diff = new int[n];
        same[0] = same[1] = k;
        diff[0] = k;
        diff[1] = k * (k - 1);
        for (int i = 2; i < n; i++) {
            same[i] = diff[i-1];
            diff[i] = diff[i-1] * (k - 1) + same[i-1] * (k - 1);
        }
        return same[n-1] + diff[n-1];
    }
}

// Space complexity can be optimized.
class Solution {
    public int numWays(int n, int k) {
        if (n == 0) return 0;
        if (n == 1) return k;
        // for n=2
        int diffcolor = k*(k-1);
        int samecolor = k;
        int temp = 0;
        // for n start from 3
        for (int i=2; i<n; i++) {
            temp = diffcolor;
            diffcolor = (diffcolor+samecolor)*(k-1);
            samecolor = temp;
        }
        return samecolor+diffcolor;
    }
}
