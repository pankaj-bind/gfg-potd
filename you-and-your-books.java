class Solution {
    long max_Books(int arr[], int n, int k) {
        long max_books = 0;
        long current_sum = 0;

        for (int end = 0; end < n; end++) {
            if (arr[end] <= k) {
                current_sum += arr[end];
                max_books = Math.max(max_books, current_sum);
            } else {
                current_sum = 0;
            }
        }
        return max_books;
    }
}
