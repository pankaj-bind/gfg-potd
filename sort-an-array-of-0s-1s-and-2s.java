class Solution {
    // Function to sort an array of 0s, 1s, and 2s
    public void sort012(ArrayList<Integer> arr) {
        int low = 0, mid = 0, high = arr.size() - 1;

        while (mid <= high) {
            switch (arr.get(mid)) {
                case 0:
                    // Swap arr[low] and arr[mid]
                    Collections.swap(arr, low, mid);
                    low++;
                    mid++;
                    break;

                case 1:
                    // No swap needed, just move mid pointer
                    mid++;
                    break;

                case 2:
                    // Swap arr[mid] and arr[high]
                    Collections.swap(arr, mid, high);
                    high--;
                    break;
            }
        }
    }
}
