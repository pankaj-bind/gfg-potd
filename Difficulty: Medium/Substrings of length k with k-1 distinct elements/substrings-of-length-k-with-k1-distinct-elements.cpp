class Solution {
public:
    int substrCount(string &s, int k) {
        if (k > s.size()) return 0;
        
        int n = s.size();
        int count = 0;
        
        vector<int> freq(26, 0);
        int distinct = 0;
        
        for (int i = 0; i < k; ++i) {
            if (freq[s[i] - 'a'] == 0)
                distinct++;
            freq[s[i] - 'a']++;
        }
        
        if (distinct == k - 1)
            count++;
        
        for (int i = k; i < n; ++i) {
            freq[s[i - k] - 'a']--;
            if (freq[s[i - k] - 'a'] == 0)
                distinct--;
            
            if (freq[s[i] - 'a'] == 0)
                distinct++;
            freq[s[i] - 'a']++;
            
            if (distinct == k - 1)
                count++;
        }
        
        return count;
    }
};
