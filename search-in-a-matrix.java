class Solution {
    public static boolean matSearch(int mat[][], int x) {
        int n = mat.length;
        int m = mat[0].length;
        
        // Start from the top-right corner
        int i = 0, j = m - 1;
        
        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                return true; // Element found
            }
            else if (mat[i][j] > x) {
                j--; // Move left if the current element is greater than x
            } else {
                i++; // Move down if the current element is smaller than x
            }
        }
        
        return false; // If we exit the loop, element is not found
    }
}
