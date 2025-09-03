class Cmp{
    public:
    bool operator()(pair<int, int>& a, pair<int, int>& b){
        if(a.first == b.first){
            return a.second > b.second;
        }
        return a.first < b.first;
    }
};
class Solution {
  public:
    int sumOfModes(vector<int>& arr, int k) {
        int n = arr.size();
        
        unordered_map<int, int> mp;
        priority_queue<pair<int, int>, vector<pair<int, int>>, Cmp> pq;
        
        int i = 0, j = 0, sum = 0;
        while(j < n){
            mp[arr[j]]++;
            pq.push({mp[arr[j]], arr[j]});
            
            if((j - i + 1) == k){
                while(!pq.empty() && pq.top().first != mp[pq.top().second]){
                    pq.pop();
                }
                
                sum += pq.top().second;
                
                mp[arr[i]]--;
                if(mp[arr[i]] == 0){
                    mp.erase(arr[i]);
                }
                
                i++;
            }
            
            j++;
        }
        return sum;
    }
};