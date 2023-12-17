class Solution {
    int findMaxSum(int arr[], int n) {
        if (n == 0) {
            return 0;
        }

        int incl = arr[0]; // Maximum sum including the first element
        int excl = 0;      // Maximum sum excluding the first element

        for (int i = 1; i < n; i++) {
            // Update incl and excl for the current element
            int newIncl = excl + arr[i];
            excl = Math.max(incl, excl);
            incl = newIncl;
        }

        // Return the maximum of incl and excl
        return Math.max(incl, excl);
    }
}
