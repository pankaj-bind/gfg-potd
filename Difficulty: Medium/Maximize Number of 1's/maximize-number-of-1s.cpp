class Solution {
  public:
    int maxOnes(vector<int>& nums, int k) {
        // code here
       int left = 0;
        int zeroCount = 0;
        
        // Instead of shrinking, we maintain window size
        for (int right = 0; right < nums.size(); right++) {
            // Count zeros in current window
            if (nums[right] == 0) {
                zeroCount++;
            }
            
            // If we exceed k zeros, slide the window
            if (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
        }
        
        // Window size is the answer
        return nums.size() - left;
    }
};
