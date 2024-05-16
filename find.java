class Solution {
    public int findPair(int n, int x, int[] arr) {
        Arrays.sort(arr); // Step 1: Sort the array
        int left = 0;
        int right = 1;
        
        // Step 2: Use two pointers to find the pair
        while (right < n) {
            int diff = arr[right] - arr[left];
            if (diff == x) {
                return 1;
            } else if (diff < x) {
                right++;
            } else {
                left++;
                // Ensure right is always ahead of left
                if (left == right) {
                    right++;
                }
            }
        }
        
        return -1;
    }
}
