class Solution {
    int[] dx = {-1, 0, 1, 0};
    int[] dy = {0, 1, 0, -1};
 
    public char[][] fill(int n, int m, char[][] mat) {
        boolean[][] vis = new boolean[n][m];
 
        // Doing DFS for 'O's in the first row
        for (int i = 0; i < m; i++) {
            if (!vis[0][i] && mat[0][i] == 'O') {
                dfs(0, i, mat, vis);
            }
        }
 
        // Doing DFS for 'O's in the last row
        for (int i = 0; i < m; i++) {
            if (!vis[n - 1][i] && mat[n - 1][i] == 'O') {
                dfs(n - 1, i, mat, vis);
            }
        }
 
        // Doing DFS for 'O's in the first column
        for (int i = 0; i < n; i++) {
            if (!vis[i][0] && mat[i][0] == 'O') {
                dfs(i, 0, mat, vis);
            }
        }
 
        // Doing DFS for 'O's in the last column
        for (int i = 0; i < n; i++) {
            if (!vis[i][m - 1] && mat[i][m - 1] == 'O') {
                dfs(i, m - 1, mat, vis);
            }
        }
 
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (mat[i][j] == 'O' && !vis[i][j]) {
                    mat[i][j] = 'X';
                }
            }
        }
 
        return mat;
    }
 
    private void dfs(int i, int j, char[][] mat, boolean[][] vis) {
        vis[i][j] = true;
        for (int k = 0; k < 4; k++) {
            if (isSafe(i + dx[k], j + dy[k], mat, vis)) {
                dfs(i + dx[k], j + dy[k], mat, vis);
            }
        }
    }
 
    private boolean isSafe(int i, int j, char[][] mat, boolean[][] vis) {
        return (i >= 0 && j >= 0 && i < mat.length && j < mat[0].length && !vis[i][j] && mat[i][j] == 'O');
    }
}