class Solution {
    public static ArrayList<ArrayList<Integer>> sumZeroMatrix(int[][] a) {
        int n = a.length;
        int m = a[0].length;

        // Step 1: Calculate the prefix sum matrix
        int[][] prefixSum = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                prefixSum[i][j] = a[i][j];
                if (i > 0) {
                    prefixSum[i][j] += prefixSum[i - 1][j];
                }
                if (j > 0) {
                    prefixSum[i][j] += prefixSum[i][j - 1];
                }
                if (i > 0 && j > 0) {
                    prefixSum[i][j] -= prefixSum[i - 1][j - 1];
                }
            }
        }

        // Step 2: Find the largest sub-matrix with sum zero
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        int maxArea = 0;

        for (int c1 = 0; c1 < m; c1++) {
            for (int c2 = c1; c2 < m; c2++) {
                for (int r1 = 0; r1 < n; r1++) {
                    for (int r2 = r1; r2 < n; r2++) {
                        int subMatrixSum = prefixSum[r2][c2];
                        if (r1 > 0) {
                            subMatrixSum -= prefixSum[r1 - 1][c2];
                        }
                        if (c1 > 0) {
                            subMatrixSum -= prefixSum[r2][c1 - 1];
                        }
                        if (r1 > 0 && c1 > 0) {
                            subMatrixSum += prefixSum[r1 - 1][c1 - 1];
                        }

                        // Check if sum is zero and update the result if needed
                        if (subMatrixSum == 0) {
                            int area = (r2 - r1 + 1) * (c2 - c1 + 1);
                            if (area > maxArea) {
                                maxArea = area;
                                result.clear();
                                for (int i = r1; i <= r2; i++) {
                                    ArrayList<Integer> row = new ArrayList<>();
                                    for (int j = c1; j <= c2; j++) {
                                        row.add(a[i][j]);
                                    }
                                    result.add(row);
                                }
                            }
                        }
                    }
                }
            }
        }

        return result;
    }
}