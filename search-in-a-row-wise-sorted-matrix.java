class Solution {
    // Function to search a given number in row-column sorted matrix.
    public boolean searchRowMatrix(int[][] mat, int x) {
        int n = mat.length;
        
        // Iterate through each row in the matrix
        for (int i = 0; i < n; i++) {
            // Use Arrays.binarySearch to find if 'x' is in this row
            if (Arrays.binarySearch(mat[i], x) >= 0) {
                return true; // If found, return true
            }
        }
        
        return false; // Return false if not found in any row
    }
}
