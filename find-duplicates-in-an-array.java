class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Traverse the input array and use the auxiliary array to count occurrences
        int[] count = new int[n];
        for (int i = 0; i < n; i++) {
            int num = arr[i];
            count[num]++;
        }
        
        // Check which elements occur more than once and add them to the result
        for (int i = 0; i < n; i++) {
            if (count[i] > 1) {
                result.add(i);
            }
        }
        
        // If no duplicates are found, return a list containing -1
        if (result.isEmpty()) {
            result.add(-1);
        }
        
        return result;
    }
}



