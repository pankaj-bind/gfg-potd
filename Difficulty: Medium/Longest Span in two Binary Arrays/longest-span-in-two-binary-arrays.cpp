class Solution {
public:
    int longestCommonSum(vector<int> &a1, vector<int> &a2) {
        int n = a1.size();
        vector<int> diff(n);
        
        for (int i = 0; i < n; i++) {
            diff[i] = a1[i] - a2[i];
        }
        
        unordered_map<int, int> prefixSumMap;
        int prefixSum = 0;
        int maxLength = 0;
        
        prefixSumMap[0] = -1;
        
        for (int i = 0; i < n; i++) {
            prefixSum += diff[i];
            
            if (prefixSumMap.find(prefixSum) != prefixSumMap.end()) {
                maxLength = max(maxLength, i - prefixSumMap[prefixSum]);
            } else {
                prefixSumMap[prefixSum] = i;
            }
        }
        
        return maxLength;
    }
};