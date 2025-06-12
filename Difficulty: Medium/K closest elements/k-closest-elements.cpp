struct Compare {
    bool operator()(const pair<int, int>& a, const pair<int, int>& b) {
        if (a.first == b.first)
            return a.second < b.second; 
        return a.first > b.first;      
    }
};
class Solution {
  public:
    vector<int> printKClosest(vector<int> arr, int k, int x) {
        priority_queue<pair<int,int>, vector<pair<int,int>>, Compare> pq;
        for(int i:arr) {
            if(i==x) {
                continue;
            }
            pq.push({abs(i-x),i});
        }
        vector<int> result;
        while(k--) {
            auto t = pq.top();
            pq.pop();
            result.push_back(t.second);
        }
        return result;
    }
};
