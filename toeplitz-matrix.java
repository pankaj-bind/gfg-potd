class Solution {
    /*You are required to complete this method*/
    boolean isToeplitz(int mat[][]) {
        int rows = mat.length;
        int cols = mat[0].length;
        
        // Check the diagonals starting from each element in the first row
        for (int col = 0; col < cols; col++) {
            if (!checkDiagonal(mat, 0, col)) {
                return false;
            }
        }
        
        // Check the diagonals starting from each element in the first column
        for (int row = 1; row < rows; row++) {
            if (!checkDiagonal(mat, row, 0)) {
                return false;
            }
        }
        
        return true;
    }
    
    boolean checkDiagonal(int[][] mat, int row, int col) {
        int value = mat[row][col];
        while (row < mat.length && col < mat[0].length) {
            if (mat[row][col] != value) {
                return false;
            }
            row++;
            col++;
        }
        return true;
    }
}
