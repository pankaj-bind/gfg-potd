class Solution {
    public void reverseArray(int arr[]) {
        // Initialize two pointers, one at the beginning and one at the end
        int start = 0;
        int end = arr.length - 1;

        // Swap elements from start to end until the pointers meet
        while (start < end) {
            // Swap arr[start] with arr[end]
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;

            // Move the pointers towards the center
            start++;
            end--;
        }
    }
}
