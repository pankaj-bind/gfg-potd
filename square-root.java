class Solution {
    long floorSqrt(long n) {
        if (n == 0 || n == 1) return n;  // Handle cases for 0 and 1
        
        long low = 1, high = n, ans = 0;
        
        while (low <= high) {
            long mid = (low + high) / 2;
            
            // Check if mid*mid is equal to n
            if (mid * mid == n) {
                return mid;
            }
            
            // If mid*mid < n, discard the left half
            if (mid * mid < n) {
                low = mid + 1;
                ans = mid;  // Update answer since mid*mid < n
            } else {
                high = mid - 1;  // Discard the right half
            }
        }
        
        return ans;
    }
}
