class Solution {
    public int[] FindExitPoint(int n, int m, int[][] matrix) {
        int[] exitPoint = new int[2];
        
        // Initial position and direction
        int row = 0, col = 0;
        int direction = 1; // 0: up, 1: right, 2: down, 3: left
        
        // Loop until exit point is found
        while (row >= 0 && row < n && col >= 0 && col < m) {
            // If current cell contains 0, continue in the same direction
            if (matrix[row][col] == 0) {
                if (direction == 0) row--;
                else if (direction == 1) col++;
                else if (direction == 2) row++;
                else col--;
            }
            // If current cell contains 1, change direction and mark it as 0
            else {
                matrix[row][col] = 0;
                direction = (direction + 1) % 4; // Turning right
                if (direction == 0) row--;
                else if (direction == 1) col++;
                else if (direction == 2) row++;
                else col--;
            }
        }
        
        // Exit point is at the last position before going out of bounds
        exitPoint[0] = row >= n ? n - 1 : (row < 0 ? 0 : row);
        exitPoint[1] = col >= m ? m - 1 : (col < 0 ? 0 : col);
        
        return exitPoint;
    }
}
