class Solution {
    // Function to check whether there is a subarray present with 0-sum or not.
    static boolean findsum(int arr[], int n) {
        // Your code here
        Set<Integer> set = new HashSet<>();
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];

            // If the current sum is already present in the set, then there is a subarray
            // with sum 0.
            if (set.contains(sum) || sum == 0) {
                return true;
            }

            // Add the current sum to the set.
            set.add(sum);
        }

        // If we reach here, then no subarray with sum 0 is found.
        return false;
    }
}