class Solution {
  public:
    int minSoldiers(vector<int>& arr, int k) {
        // code here
        int n=arr.size();
        priority_queue<int>pq;
        int count=0;
        for(int &num:arr){
        if(num%k==0)count++;
        else pq.push(k-(num%k));
        if(pq.size()>((n % 2) ? (n / 2) + 1 : (n / 2)) - count)pq.pop();
        }
        if(count>((n % 2) ? (n / 2) + 1 : (n / 2)))return 0;
        int sum=0;
        while(!pq.empty()){
            sum+=pq.top();
            pq.pop();
        }
        return sum;
    }
};
