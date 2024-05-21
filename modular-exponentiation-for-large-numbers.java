class Solution {
    public long PowMod(long x, long n, long m) {
        if (m == 1) return 0; // Any number % 1 is 0
        long result = 1;
        x = x % m; // Take x % m initially

        while (n > 0) {
            // If n is odd, multiply x with the result
            if ((n & 1) == 1) {
                result = (result * x) % m;
            }
            // n must be even now, so we divide it by 2
            n = n >> 1;
            x = (x * x) % m; // Change x to x^2
        }
        
        return result;
    }
}
