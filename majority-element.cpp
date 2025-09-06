class Solution {
  public:
    int majorityElement(vector<int>& arr) {
        int n = arr.size();
        int candidate = -1, count = 0;
        
        // Step 1: Find candidate
        for (int num : arr) {
            if (count == 0) {
                candidate = num;
                count = 1;
            } else if (num == candidate) {
                count++;
            } else {
                count--;
            }
        }
        
        // Step 2: Verify candidate
        count = 0;
        for (int num : arr) {
            if (num == candidate) count++;
        }
        
        if (count > n / 2) return candidate;
        return -1;
    }
};
