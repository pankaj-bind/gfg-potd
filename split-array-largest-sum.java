class Solution {
    public static int splitArray(int[] arr, int N, int K) {
        int low = Arrays.stream(arr).max().getAsInt(); // Minimum possible maximum subarray sum
        int high = Arrays.stream(arr).sum(); // Maximum possible maximum subarray sum

        while (low < high) {
            int mid = low + (high - low) / 2;

            if (isValid(arr, N, K, mid)) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private static boolean isValid(int[] arr, int N, int K, int mid) {
        int count = 1;
        int sum = 0;

        for (int num : arr) {
            sum += num;

            if (sum > mid) {
                count++;
                sum = num;
            }
        }

        return count <= K;
    }
}