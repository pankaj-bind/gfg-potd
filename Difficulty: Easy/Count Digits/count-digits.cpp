class Solution {
  public:
    int evenlyDivides(int n) {
        int original = n;
        int count = 0;
        
        while (n > 0) {
            int digit = n % 10;
            n = n / 10;
            if (digit != 0 && original % digit == 0) {
                count++;
            }
        }
        return count;
    }
};
