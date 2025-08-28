class Solution {
  public:
    long long merge_count(vector<int>& arr, int l, int r) {
        if (l >= r) return 0;
        int m = l + (r - l) / 2;
        long long cnt = merge_count(arr, l, m) + merge_count(arr, m+1, r);
        // count cross-pairs
        int j = m+1;
        for (int i = l; i <= m; ++i) 
        {
            while (j <= r && arr[i] > 2LL * arr[j]) ++j;
            cnt += (j - (m+1));
        }
        // merge step
        vector<int> tmp;
        int p = l, q = m+1;
        while(p<=m && q<=r) 
        {
            if (arr[p] <= arr[q]) tmp.push_back(arr[p++]);
            else tmp.push_back(arr[q++]);
        }
        while (p <= m) tmp.push_back(arr[p++]);
        while (q <= r) tmp.push_back(arr[q++]);
        for (int k = l; k <= r; ++k)
            arr[k] = tmp[k - l];
        return cnt;
    }
    
    int countRevPairs(vector<int> &arr) {
        // Code here
        return (int)merge_count(arr, 0, (int)arr.size() - 1);
    }
};
