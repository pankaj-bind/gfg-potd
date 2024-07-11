class Solution {

    private static final int[] DIRECTION_X = {-1, 1, 0, 0};
    private static final int[] DIRECTION_Y = {0, 0, -1, 1};
    
    public int MaxConnection(int[][] grid) {
        int n = grid.length;
        int maxConnected = 0;
        
        // Step 1: Calculate the size of each connected component
        boolean[][] visited = new boolean[n][n];
        Map<Integer, Integer> componentSize = new HashMap<>();
        int componentId = 2; // Start from 2 because 0 and 1 are already in the grid
        
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1 && !visited[i][j]) {
                    int size = dfs(grid, visited, i, j, componentId);
                    componentSize.put(componentId, size);
                    maxConnected = Math.max(maxConnected, size);
                    componentId++;
                }
            }
        }
        
        // Step 2: Try changing each 0 to 1 and calculate the max connected component
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 0) {
                    Set<Integer> neighboringComponents = new HashSet<>();
                    for (int d = 0; d < 4; d++) {
                        int ni = i + DIRECTION_X[d];
                        int nj = j + DIRECTION_Y[d];
                        if (isValid(ni, nj, n) && grid[ni][nj] > 1) {
                            neighboringComponents.add(grid[ni][nj]);
                        }
                    }
                    
                    int newSize = 1; // the cell itself
                    for (int id : neighboringComponents) {
                        newSize += componentSize.get(id);
                    }
                    maxConnected = Math.max(maxConnected, newSize);
                }
            }
        }
        
        return maxConnected;
    }
    
    private int dfs(int[][] grid, boolean[][] visited, int x, int y, int componentId) {
        int n = grid.length;
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{x, y});
        visited[x][y] = true;
        grid[x][y] = componentId;
        int size = 0;
        
        while (!stack.isEmpty()) {
            int[] cell = stack.pop();
            int cx = cell[0];
            int cy = cell[1];
            size++;
            
            for (int d = 0; d < 4; d++) {
                int nx = cx + DIRECTION_X[d];
                int ny = cy + DIRECTION_Y[d];
                if (isValid(nx, ny, n) && !visited[nx][ny] && grid[nx][ny] == 1) {
                    stack.push(new int[]{nx, ny});
                    visited[nx][ny] = true;
                    grid[nx][ny] = componentId;
                }
            }
        }
        
        return size;
    }
    
    private boolean isValid(int x, int y, int n) {
        return x >= 0 && x < n && y >= 0 && y < n;
    }
}
