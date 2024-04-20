class Solution
{
    // Function to return a list containing the union of the two arrays.
    public static ArrayList<Integer> findUnion(int arr1[], int arr2[], int n, int m)
    {
        // Initialize variables to keep track of array indices and store the result.
        int i = 0, j = 0;
        ArrayList<Integer> union = new ArrayList<>();
        
        // Loop until we reach the end of either array.
        while (i < n && j < m) {
            // If the current element of arr1 is smaller, add it to the union.
            if (arr1[i] < arr2[j]) {
                // Add the element if it's different from the previous one or if it's the first element.
                if (i == 0 || arr1[i] != arr1[i - 1])
                    union.add(arr1[i]);
                i++;
            }
            // If the current element of arr2 is smaller, add it to the union.
            else if (arr2[j] < arr1[i]) {
                // Add the element if it's different from the previous one or if it's the first element.
                if (j == 0 || arr2[j] != arr2[j - 1])
                    union.add(arr2[j]);
                j++;
            }
            // If both elements are equal, add any of them to the union.
            else {
                // Add the element if it's different from the previous one or if it's the first element.
                if (i == 0 || arr1[i] != arr1[i - 1])
                    union.add(arr1[i]);
                i++;
                j++;
            }
        }
        
        // Add remaining elements of arr1, if any.
        while (i < n) {
            // Add the element if it's different from the previous one.
            if (i == 0 || arr1[i] != arr1[i - 1])
                union.add(arr1[i]);
            i++;
        }
        
        // Add remaining elements of arr2, if any.
        while (j < m) {
            // Add the element if it's different from the previous one.
            if (j == 0 || arr2[j] != arr2[j - 1])
                union.add(arr2[j]);
            j++;
        }
        
        return union;
    }
}