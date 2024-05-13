class Solution {
    static class Cell {
        int row, col, effort;
        
        public Cell(int row, int col, int effort) {
            this.row = row;
            this.col = col;
            this.effort = effort;
        }
    }
    
    public static int MinimumEffort(int rows, int columns, int[][] heights) {
        // Directions for movement: up, down, left, right
        int[][] dirs = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        
        // Initialize a priority queue for BFS based on effort
        PriorityQueue<Cell> pq = new PriorityQueue<>((a, b) -> a.effort - b.effort);
        // Store minimum efforts for each cell
        int[][] minEffort = new int[rows][columns];
        
        // Initialize all efforts to maximum value
        for (int i = 0; i < rows; i++) {
            Arrays.fill(minEffort[i], Integer.MAX_VALUE);
        }
        
        // Add the starting cell with effort 0 to the priority queue
        pq.offer(new Cell(0, 0, 0));
        // Minimum effort to reach starting cell is 0
        minEffort[0][0] = 0;
        
        // Perform BFS
        while (!pq.isEmpty()) {
            Cell curr = pq.poll();
            
            // Check all possible directions
            for (int[] dir : dirs) {
                int newRow = curr.row + dir[0];
                int newCol = curr.col + dir[1];
                
                // Check if the new position is within bounds
                if (newRow >= 0 && newRow < rows && newCol >= 0 && newCol < columns) {
                    // Calculate the maximum absolute difference in heights
                    int effort = Math.max(curr.effort, Math.abs(heights[newRow][newCol] - heights[curr.row][curr.col]));
                    
                    // If the new effort is less than the minimum effort stored for this cell
                    if (effort < minEffort[newRow][newCol]) {
                        // Update the minimum effort and add the cell to the priority queue
                        minEffort[newRow][newCol] = effort;
                        pq.offer(new Cell(newRow, newCol, effort));
                    }
                }
            }
        }
        
        // Minimum effort to reach the bottom-right cell
        return minEffort[rows - 1][columns - 1];
    }
}