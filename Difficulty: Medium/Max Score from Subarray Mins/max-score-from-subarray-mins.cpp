class Solution {
  public:
    int maxSum(vector<int> &arr) {
        int n = arr.size();
        int maxScore = 0;
        
        for (int i = 0; i < n - 1; ++i) {
            int first = arr[i];
            int second = arr[i + 1];
            int sum = first + second;
            maxScore = max(maxScore, sum);
        }
        
        return maxScore;
    }
};
