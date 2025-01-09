class Solution {
    static ArrayList<Integer> subarraySum(int[] arr, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        int start = 0, sum = 0;

        for (int end = 0; end < arr.length; end++) {
            sum += arr[end];

            // Shrink the window as long as the sum exceeds the target
            while (sum > target && start <= end) {
                sum -= arr[start];
                start++;
            }

            // Check if the current sum matches the target
            if (sum == target) {
                result.add(start + 1); // Convert to 1-based index
                result.add(end + 1);   // Convert to 1-based index
                return result;
            }
        }

        // If no subarray with the specified sum is found
        result.add(-1);
        return result;
    }
}
