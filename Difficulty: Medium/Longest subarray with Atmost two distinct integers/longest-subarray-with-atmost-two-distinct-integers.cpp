class Solution {
public:
    int totalElements(vector<int> &arr) {
        int left = 0, right = 0;
        int n = arr.size();
        unordered_map<int, int> freq;
        int maxLength = 0;
        int distinctCount = 0;

        for (right = 0; right < n; ++right) {
            freq[arr[right]]++;
            if (freq[arr[right]] == 1) {
                distinctCount++;
            }

            while (distinctCount > 2) {
                freq[arr[left]]--;
                if (freq[arr[left]] == 0) {
                    distinctCount--;
                }
                left++;
            }

            maxLength = max(maxLength, right - left + 1);
        }

        return maxLength;
    }
};
