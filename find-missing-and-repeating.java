class Solve {
    int[] findTwoElement(int arr[]) {
        int n = arr.length;
        int[] result = new int[2]; // result[0] will hold repeating, result[1] will hold missing
        
        // Step 1: Mark visited elements by making them negative
        for (int i = 0; i < n; i++) {
            int index = Math.abs(arr[i]) - 1; // Get the index corresponding to the element value
            
            if (arr[index] < 0) {
                // If already negative, this is the repeating number
                result[0] = Math.abs(arr[i]);
            } else {
                // Mark the value at this index as negative
                arr[index] = -arr[index];
            }
        }
        
        // Step 2: Find the missing number
        for (int i = 0; i < n; i++) {
            if (arr[i] > 0) {
                // The index + 1 is the missing number (since index is 0-based)
                result[1] = i + 1;
                break;
            }
        }
        
        return result;
    }
}
