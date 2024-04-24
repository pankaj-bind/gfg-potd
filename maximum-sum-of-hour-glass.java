class Solution {
    int findMaxSum(int n, int m, int mat[][]) {
        int maxSum = Integer.MIN_VALUE; // Initialize maxSum to the smallest possible integer
        
        // Iterate through each cell in the matrix
        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                // Check if the current cell (i, j) forms the center of a valid hourglass
                if (isValidHourglass(i, j, n, m)) {
                    // Calculate the sum of the hourglass
                    int sum = calculateHourglassSum(i, j, mat);
                    // Update maxSum if the current sum is greater
                    maxSum = Math.max(maxSum, sum);
                }
            }
        }
        
        // If no valid hourglass is found, return -1, otherwise return the maximum sum
        return maxSum != Integer.MIN_VALUE ? maxSum : -1;
    }
    
    // Function to check if the given cell forms the center of a valid hourglass
    boolean isValidHourglass(int row, int col, int n, int m) {
        return row + 2 < n && col + 2 < m;
    }
    
    // Function to calculate the sum of the hourglass with the center at the given cell
    int calculateHourglassSum(int row, int col, int[][] mat) {
        int sum = 0;
        // Calculate the sum of the hourglass
        for (int i = row; i <= row + 2; i++) {
            for (int j = col; j <= col + 2; j++) {
                // Exclude the corner elements which are not part of the hourglass
                if (!((i == row + 1 && j == col) || (i == row + 1 && j == col + 2))) {
                    sum += mat[i][j];
                }
            }
        }
        return sum;
    }
}
