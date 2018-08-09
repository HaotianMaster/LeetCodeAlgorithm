class Solution {
    public int[][] flipAndInvertImage(int[][] A) {
        if (A == null || A.length == 0 || A[0].length == 0) return null;
        int m = A.length, n = A[0].length;
        for (int i = 0; i < m; i++) {
            flip(A, i, n - 1);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i][j] == 0) {
                    A[i][j] = 1;
                }
                else {
                    A[i][j] = 0;
                }
            }
        }
        return A;
    }
    public void flip(int[][] A, int i, int n) {
        int left = 0, right = n;
        while (left < right) {
            int temp = A[i][left];
            A[i][left] = A[i][right];
            A[i][right] = temp;
            left++;
            right--;
        }
    }
}