class Solution {
    public int findCoverage(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int coverage = 0;

        // Directions arrays for left, right, up, down
        int[] rowDirs = {0, 0, -1, 1};
        int[] colDirs = {-1, 1, 0, 0};

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < 4; k++) {
                        int newRow = i + rowDirs[k];
                        int newCol = j + colDirs[k];
                        if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && matrix[newRow][newCol] == 1) {
                            coverage++;
                        }
                    }
                }
            }
        }
        return coverage;
    }
}
