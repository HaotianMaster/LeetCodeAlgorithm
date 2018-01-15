// Iteratively rotate matrix layer by layer from outter to inner. 

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length==0) return;
        int round = matrix.length/2;
        int len = matrix.length-1;
        for (int i=0; i<round; i++) {
            for (int j=i; j<len-i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[len-j][i];
                matrix[len-j][i] = matrix[len-i][len-j];
                matrix[len-i][len-j] = matrix[j][len-i];
                matrix[j][len-i] = temp;
            }
        }
    }
}


// Recursively rotate matrix layer by layer from outter to inner. 

class Solution {
    public void rotate(int[][] matrix) {
        if (matrix.length==0) return;
        int round = 0;
        rotateHelper(matrix, round);
    }
    private void rotateHelper(int[][] matrix, int round) {
        if (round==matrix.length/2) return;
        int len = matrix.length-1;
        for (int i=round; i<len-round; i++) {
            int temp = matrix[round][i];
            matrix[round][i] = matrix[len-i][round];
            matrix[len-i][round] = matrix[len-round][len-i];
            matrix[len-round][len-i] = matrix[i][len-round];
            matrix[i][len-round] = temp;            
        }
        round++;
        rotateHelper(matrix, round);
    }
}
