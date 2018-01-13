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
