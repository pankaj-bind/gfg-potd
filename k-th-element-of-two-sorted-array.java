// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // Ensure arr1 is the smaller array
        if (arr1.length > arr2.length) {
            return kthElement(k, arr2, arr1);
        }

        int n = arr1.length;
        int m = arr2.length;

        int low = Math.max(0, k - m);
        int high = Math.min(k, n);

        while (low <= high) {
            int mid1 = (low + high) / 2;
            int mid2 = k - mid1;

            int left1 = (mid1 == 0) ? Integer.MIN_VALUE : arr1[mid1 - 1];
            int right1 = (mid1 == n) ? Integer.MAX_VALUE : arr1[mid1];

            int left2 = (mid2 == 0) ? Integer.MIN_VALUE : arr2[mid2 - 1];
            int right2 = (mid2 == m) ? Integer.MAX_VALUE : arr2[mid2];

            if (left1 <= right2 && left2 <= right1) {
                return Math.max(left1, left2);
            } else if (left1 > right2) {
                high = mid1 - 1;
            } else {
                low = mid1 + 1;
            }
        }

        throw new IllegalArgumentException("Input arrays are not sorted or invalid k.");
    }
}
