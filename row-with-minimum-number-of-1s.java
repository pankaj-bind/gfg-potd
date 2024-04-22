class Solution {
    int minRow(int n, int m, int a[][]) {
        int minRowIndex = 0; // Initialize the index of the row with minimum 1's count
        int minOnesCount = Integer.MAX_VALUE; // Initialize the minimum count of 1's to maximum possible value

        // Iterate through each row
        for (int i = 0; i < n; i++) {
            int onesCount = 0; // Initialize count of 1's in the current row

            // Count the number of 1's in the current row
            for (int j = 0; j < m; j++) {
                if (a[i][j] == 1) {
                    onesCount++;
                }
            }

            // If the count of 1's in the current row is less than the minimum count found so far,
            // update the minimum count and the corresponding row index
            if (onesCount < minOnesCount) {
                minOnesCount = onesCount;
                minRowIndex = i;
            }
        }

        // Return the index of the row with the minimum count of 1's
        return minRowIndex + 1; // Adjust the 0-based index to 1-based index
    }
}
