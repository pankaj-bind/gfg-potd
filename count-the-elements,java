class Solution {
    public static int[] countElements(int a[], int b[], int n, int query[], int q) {
        int[] result = new int[q];
        
        // Step 1: Iterate through each query
        for (int i = 0; i < q; i++) {
            int count = 0;
            
            // Step 2: Find the value of a[x]
            int x = query[i];
            int val = a[x];
            
            // Step 3: Iterate through array b
            for (int j = 0; j < n; j++) {
                // Step 4: Count elements less than or equal to a[x]
                if (b[j] <= val) {
                    count++;
                }
            }
            
            // Step 5: Store the count for the current query
            result[i] = count;
        }
        
        // Step 6: Return the result array
        return result;
    }
}