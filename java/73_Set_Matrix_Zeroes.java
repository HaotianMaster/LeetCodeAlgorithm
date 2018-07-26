/**
* Use the first row and first column as the marker to store 
* the condition of the corresponding row and column. 
* If there is a 0 at matrix[i][j], then matrix[i][0] = 0; matrix[0][j] = 0. 
* For the first row and column, since matrix[0][0] can only store 1 state, 
* use a extra marker row0 or col0 to store the state.
**/

class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        
        boolean firstRowHasZero = false;
        boolean firstColHasZero = false;        
        for (int i = 0; i < m; i++) {
            if (matrix[i][0] == 0) {
                firstColHasZero = true;
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (matrix[0][j] == 0) {
                firstRowHasZero = true;
                break;
            }
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for (int i = 1; i < m; i++) {
            if (matrix[i][0] == 0) {
                for (int j = 1; j < n; j++) matrix[i][j] = 0;
            }
        }
        for (int j = 1; j < n; j++) {
            if (matrix[0][j] == 0) {
                for (int i = 1; i < m; i++) matrix[i][j] = 0;              
            }
        }
        
        if (firstColHasZero) {
            for (int i = 0; i < m; i++) matrix[i][0] = 0;          
        }
        if (firstRowHasZero) {
            for (int j = 0; j < n; j++) matrix[0][j] = 0;          
        }       
    }
}



