class Solution {
    public ArrayList<String> findPath(int[][] mat) {
        ArrayList<String> paths = new ArrayList<>();
        int n = mat.length;
        
        // Base case: if the starting cell is blocked
        if (mat[0][0] == 0 || mat[n - 1][n - 1] == 0) {
            return paths;
        }
        
        boolean[][] visited = new boolean[n][n];
        findPaths(mat, n, 0, 0, "", paths, visited);
        return paths;
    }
    
    private void findPaths(int[][] mat, int n, int i, int j, String path, ArrayList<String> paths, boolean[][] visited) {
        // If the destination is reached, add the path to the result
        if (i == n - 1 && j == n - 1) {
            paths.add(path);
            return;
        }
        
        // Mark the current cell as visited
        visited[i][j] = true;
        
        // Move down
        if (isSafe(mat, n, i + 1, j, visited)) {
            findPaths(mat, n, i + 1, j, path + 'D', paths, visited);
        }
        
        // Move right
        if (isSafe(mat, n, i, j + 1, visited)) {
            findPaths(mat, n, i, j + 1, path + 'R', paths, visited);
        }
        
        // Move up
        if (isSafe(mat, n, i - 1, j, visited)) {
            findPaths(mat, n, i - 1, j, path + 'U', paths, visited);
        }
        
        // Move left
        if (isSafe(mat, n, i, j - 1, visited)) {
            findPaths(mat, n, i, j - 1, path + 'L', paths, visited);
        }
        
        // Backtrack: unmark the current cell as visited
        visited[i][j] = false;
    }
    
    private boolean isSafe(int[][] mat, int n, int i, int j, boolean[][] visited) {
        // Check if the cell is within the boundaries of the maze,
        // is not blocked, and has not been visited yet.
        return (i >= 0 && i < n && j >= 0 && j < n && mat[i][j] == 1 && !visited[i][j]);
    }
}
