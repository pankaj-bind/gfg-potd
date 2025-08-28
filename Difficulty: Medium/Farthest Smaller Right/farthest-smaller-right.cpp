class Solution {
public:
    vector<int> farMin(vector<int>& arr) {
        int n = arr.size();
        vector<pair<int , int>>vec;
        for(int i = 0; i < n; i++)
            vec.push_back({arr[i] , i});
        sort(vec.begin() , vec.end());
        vector<int>ans(n , -1);
        int maxi = 0;
        for(int i = 0; i < n; i++)
        {
            int num = vec[i].first , idx = vec[i].second;
            if(i > 0 && vec[i - 1].first == num)
            {
                int x = ans[vec[i - 1].second];
                if(x > idx)
                    ans[idx] = x;
            }
            else
            {
                if(maxi > idx)
                    ans[idx] = maxi;
            }
            maxi = max(maxi , idx);
        }
        return ans;
    }
};
