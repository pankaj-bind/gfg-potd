class Solution {
    public void setMatrixZeroes(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;

        // Flags to check if the first row or the first column should be zeroed
        boolean row0 = false, col0 = false;

        // Step 1: Check if the first row has any zeros
        for (int j = 0; j < m; j++) {
            if (mat[0][j] == 0) {
                row0 = true;
                break;
            }
        }

        // Step 2: Check if the first column has any zeros
        for (int i = 0; i < n; i++) {
            if (mat[i][0] == 0) {
                col0 = true;
                break;
            }
        }

        // Step 3: Use the first row and first column to mark zeros
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][j] == 0) {
                    mat[i][0] = 0;  // Mark the i-th column
                    mat[0][j] = 0;  // Mark the j-th row
                }
            }
        }

        // Step 4: Set matrix cells to zero using the marks in the first row and first column
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < m; j++) {
                if (mat[i][0] == 0 || mat[0][j] == 0) {
                    mat[i][j] = 0;
                }
            }
        }

        // Step 5: Handle the first row
        if (row0) {
            for (int j = 0; j < m; j++) {
                mat[0][j] = 0;
            }
        }

        // Step 6: Handle the first column
        if (col0) {
            for (int i = 0; i < n; i++) {
                mat[i][0] = 0;
            }
        }
    }
}
