class Solution {
    public List<Integer> find3Numbers(int[] arr) {
        int n = arr.length;
        if (n < 3) return new ArrayList<>();  // Edge case: no such subsequence can exist.

        // Arrays to store left minimum and right maximum values.
        int[] left_min = new int[n];
        int[] right_max = new int[n];

        // Initialize the left_min array.
        left_min[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left_min[i] = Math.min(left_min[i - 1], arr[i]);
        }

        // Initialize the right_max array.
        right_max[n - 1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right_max[i] = Math.max(right_max[i + 1], arr[i]);
        }

        // Traverse the array and find the valid triplet.
        for (int i = 1; i < n - 1; i++) {
            if (left_min[i - 1] < arr[i] && arr[i] < right_max[i + 1]) {
                List<Integer> result = new ArrayList<>();
                result.add(left_min[i - 1]);
                result.add(arr[i]);
                result.add(right_max[i + 1]);
                return result;
            }
        }

        // If no such subsequence exists, return an empty list.
        return new ArrayList<>();
    }
}

