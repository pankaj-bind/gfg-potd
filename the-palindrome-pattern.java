class Solution {
    public String pattern(int[][] arr) {
        int n = arr.length;
        
        // Check rows for palindromes
        for (int i = 0; i < n; i++) {
            if (isPalindrome(arr[i])) {
                return (i + " R");
            }
        }
        
        // Check columns for palindromes
        for (int j = 0; j < n; j++) {
            int[] column = new int[n];
            for (int i = 0; i < n; i++) {
                column[i] = arr[i][j];
            }
            if (isPalindrome(column)) {
                return (j + " C");
            }
        }
        
        // No palindrome found
        return "-1";
    }
    
    // Function to check if an array forms a palindrome
    private boolean isPalindrome(int[] array) {
        int left = 0;
        int right = array.length - 1;
        
        while (left < right) {
            if (array[left] != array[right]) {
                return false;
            }
            left++;
            right--;
        }
        
        return true;
    }
              }
