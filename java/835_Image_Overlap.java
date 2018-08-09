//Transform the 2D space to a 1D space.
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int N = A.length;
        List<Integer> LA = new ArrayList<>();
        List<Integer> LB = new ArrayList<>();
        HashMap<Integer, Integer> count = new HashMap<>();
        // Assume ab for row and cd for col, I make it abcd as coordinate.
        for (int i = 0; i < N * N; ++i) {
            if (A[i / N][i % N] == 1) {
                LA.add(i / N * 100 + i % N);
            }
        }
        for (int i = 0; i < N * N; ++i) {
            if (B[i / N][i % N] == 1) {
                LB.add(i / N * 100 + i % N);
            }
        }
        for (int i : LA) {
            for (int j : LB) {
                count.put(i - j, count.getOrDefault(i - j, 0) + 1);
            }
        }
                
        int res = 0;
        for (int i : count.values()) res = Math.max(res, i);
        return res;        
    }
}

//Expand A from a 3x3 to a 9x9 graph and fill the blank with 0, then try every possible postion using B. 
//Considering n<=30, it is not the best but still acceptable.
class Solution {
    public int largestOverlap(int[][] A, int[][] B) {
        int n=A.length, res=0;
        int[][] Ap= new int[3*n][3*n];
        for (int i=n; i<2*n; i++){
            for (int j=n; j<2*n; j++){
                Ap[i][j]=A[i-n][j-n];
            }
        }
        for (int i=0; i<=2*n; i++){
            for (int j=0; j<=2*n; j++){
                res=Math.max(res, helper(Ap, B, i, j));
            }
        }
        return res;
    }
    public int helper(int[][] A, int[][] B, int x, int y){
        int n=B.length, sum=0;
        for (int i=0; i<n; i++){
            for (int j=0; j<n; j++){
                sum+=B[i][j]*A[x+i][y+j];
            }
        }
        return sum;
    }
}