class Solution
{
    //Function to modify the matrix such that if a matrix cell matrix[i][j]
    //is 1 then all the cells in its ith row and jth column will become 1.
    void booleanMatrix(int matrix[][])
    {
        int R = matrix.length;
        int C = matrix[0].length;
        int[] row = new int[R];
        int[] col = new int[C];
        
        // Traverse through the matrix to mark rows and columns to be modified.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (matrix[i][j] == 1) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        // Modify the matrix based on row and col arrays.
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (row[i] == 1 || col[j] == 1) {
                    matrix[i][j] = 1;
                }
            }
        }
    }
}
