class Solution {
  public:
    int smallestDivisor(vector<int>& arr, int k) {
        int low = 1, high = *max_element(arr.begin(), arr.end());
        
        auto computeSum = [&](int divisor) {
            int sum = 0;
            for (int num : arr) {
                sum += (num + divisor - 1) / divisor; 
            }
            return sum;
        };
        
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (computeSum(mid) <= k)
                high = mid;
            else
                low = mid + 1;
        }
        
        return low;
    }
};
