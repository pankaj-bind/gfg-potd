class Solution {
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0) return 0;

        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited = new boolean[n][m];
        int islandCount = 0;

        // Directions for moving in all 8 directions
        int[] rowDirections = {-1, -1, -1, 0, 0, 1, 1, 1};
        int[] colDirections = {-1, 0, 1, -1, 1, -1, 0, 1};

        // Loop through each cell in the grid
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                // If the cell is land and not visited, it's a new island
                if (grid[i][j] == '1' && !visited[i][j]) {
                    islandCount++;
                    // Perform DFS to mark all connected land cells
                    dfs(grid, visited, i, j, rowDirections, colDirections);
                }
            }
        }
        return islandCount;
    }

    private void dfs(char[][] grid, boolean[][] visited, int row, int col, int[] rowDirections, int[] colDirections) {
        // Mark the current cell as visited
        visited[row][col] = true;

        // Explore all 8 possible directions
        for (int d = 0; d < 8; d++) {
            int newRow = row + rowDirections[d];
            int newCol = col + colDirections[d];

            // Check if the new position is valid and is land
            if (isValid(grid, visited, newRow, newCol)) {
                dfs(grid, visited, newRow, newCol, rowDirections, colDirections);
            }
        }
    }

    private boolean isValid(char[][] grid, boolean[][] visited, int row, int col) {
        // Check if the cell is within bounds and not visited and is land
        return (row >= 0 && row < grid.length && col >= 0 && col < grid[0].length && 
                grid[row][col] == '1' && !visited[row][col]);
    }
}
