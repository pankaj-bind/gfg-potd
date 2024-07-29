class Solution {
    public int rowWithMax1s(int arr[][]) {
        int n = arr.length;
        int m = arr[0].length;
        int maxRowIndex = -1;
        int j = m - 1; // start from the top-right corner
        
        for (int i = 0; i < n; i++) {
            while (j >= 0 && arr[i][j] == 1) {
                j--; // move left
                maxRowIndex = i; // update the row index with max 1s
            }
        }
        return maxRowIndex;
    }
}
