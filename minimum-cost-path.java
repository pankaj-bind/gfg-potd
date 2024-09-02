class Solution {
    // Directions for movement in the grid
    private static final int[] dx = {-1, 1, 0, 0}; // Up, Down, Left, Right
    private static final int[] dy = {0, 0, -1, 1};

    // Function to return the minimum cost to reach the bottom right cell from top left cell.
    public int minimumCostPath(int[][] grid) {
        int n = grid.length;

        // Priority Queue to hold cells with their cost, starting with the top-left corner.
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[2] - b[2]);

        // Distance array to store the minimum cost to reach each cell.
        int[][] dist = new int[n][n];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);

        // Start from the top-left corner (0, 0)
        pq.offer(new int[] {0, 0, grid[0][0]});
        dist[0][0] = grid[0][0];

        // While there are cells to process
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int x = current[0], y = current[1], cost = current[2];

            // If we've reached the bottom-right corner, return the cost
            if (x == n - 1 && y == n - 1) return cost;

            // Explore the 4 possible directions
            for (int i = 0; i < 4; i++) {
                int newX = x + dx[i];
                int newY = y + dy[i];

                // Check if the new position is within bounds
                if (newX >= 0 && newX < n && newY >= 0 && newY < n) {
                    int newCost = cost + grid[newX][newY];
                    
                    // If we find a shorter path to the new cell, update it
                    if (newCost < dist[newX][newY]) {
                        dist[newX][newY] = newCost;
                        pq.offer(new int[] {newX, newY, newCost});
                    }
                }
            }
        }

        return dist[n - 1][n - 1]; // Minimum cost to reach bottom-right corner
    }
}
