
class Solution {
    long findNth(long n) {
        long result = 0;
        long base = 1;
        
        while (n > 0) {
           
            result += (n % 9) * base;
  
            n /= 9;
            base *= 10;
        }
        
        return result;
    }
}
