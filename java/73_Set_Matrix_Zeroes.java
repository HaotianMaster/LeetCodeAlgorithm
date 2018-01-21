/**
* Use the first row and first column as the marker to store 
* the condition of the corresponding row and column. 
* If there is a 0 at matrix[i][j], then matrix[i][0] = 0; matrix[0][j] = 0. 
* For the first row and column, since matrix[0][0] can only store 1 state, 
* use a extra marker row0 or col0 to store the state.
**/

class Solution {
    public void setZeroes(int[][] matrix) {
        if (matrix==null || matrix.length==0 || matrix[0].length==0) return;
        boolean firstrowzero = false;
        boolean firstcolzero = false;
        for (int i=0; i<matrix[0].length; i++) {
            if (matrix[0][i]==0) {
                firstrowzero = true;
                break;
            }
        }
        for (int i=0; i<matrix.length; i++) {
            if (matrix[i][0]==0) {
                firstcolzero = true;
                break;
            }
        }
        for (int i=1; i<matrix.length; i++) {
            for (int j=1; j<matrix[0].length; j++) {
                if (matrix[i][j]==0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i=1; i<matrix.length; i++) {
            if (matrix[i][0]==0) {
                for (int j=1; j<matrix[0].length; j++) matrix[i][j] = 0;
            }
        } 
        for (int i=1; i<matrix[0].length; i++) {
            if (matrix[0][i]==0) {
                for (int j=1; j<matrix.length; j++) matrix[j][i] = 0;
            }
        } 
        if (firstrowzero==true) {
            for (int i=0; i<matrix[0].length; i++) matrix[0][i] = 0;
        }
        if (firstcolzero==true) {
            for (int i=0; i<matrix.length; i++) matrix[i][0] = 0;
        }
    }
}