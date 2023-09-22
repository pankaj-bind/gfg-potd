class GFG {
    ArrayList<Integer> find(int arr[], int n, int x) {
        ArrayList<Integer> result = new ArrayList<>();
        int firstOccurrence = binarySearchFirstOccurrence(arr, n, x);
        int lastOccurrence = binarySearchLastOccurrence(arr, n, x);
        result.add(firstOccurrence);
        result.add(lastOccurrence);
        return result;
    }

    int binarySearchFirstOccurrence(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        int firstOccurrence = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                firstOccurrence = mid;
                high = mid - 1; // Look in the left half for first occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return firstOccurrence;
    }

    int binarySearchLastOccurrence(int arr[], int n, int x) {
        int low = 0, high = n - 1;
        int lastOccurrence = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (arr[mid] == x) {
                lastOccurrence = mid;
                low = mid + 1; // Look in the right half for last occurrence
            } else if (arr[mid] < x) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return lastOccurrence;
    }
}