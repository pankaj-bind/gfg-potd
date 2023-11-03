class Solution {
    boolean checkTriplet(int[] arr, int n) {
        HashSet<Integer> squares = new HashSet<>();
        
        // Calculate squares and store them in HashSet
        for (int num : arr) {
            squares.add(num * num);
        }
        
        // Iterate over pairs of elements
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int sumOfSquares = arr[i]*arr[i] + arr[j]*arr[j];
                
                // Check if sumOfSquares exists in the HashSet
                if (squares.contains(sumOfSquares)) {
                    return true;
                }
            }
        }
        
        return false;
    }
}