class Solution {
    public static int rotateDelete(ArrayList<Integer> arr) {
        int n = arr.size();
        int operations = n / 2;  // We perform n/2 operations
        for (int k = 1; k <= operations; k++) {
            // Right-rotate the array by 1
            int lastElement = arr.remove(arr.size() - 1);  // Remove the last element
            arr.add(0, lastElement);  // Add it to the front of the array

            // Delete the (n - k + 1)th element from the beginning (0-indexed)
            int deleteIndex = arr.size() - k;  // This is the (n - k + 1)th element
            arr.remove(deleteIndex);
        }
        return arr.get(0);  // Return the first element after operations
    }
}
