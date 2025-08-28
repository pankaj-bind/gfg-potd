class Solution {
  public:
    bool isOk(int m, vector<int>& arr, int k, int& n){
        int c = 1;
        int prev = arr[0];
        
        for(int i=1;i<n;i++){
            int diff = arr[i]-prev;
            if(diff >= m){
                c++;
                prev = arr[i];
            }
            if(c>=k)
              return true;
        }
        return false;
    }
  
    int maxMinDiff(vector<int>& arr, int k) {
        // code here
        int n = arr.size();
        sort(arr.begin(), arr.end());
        
        int low = 0;
        int high = arr[n-1]-arr[0];
        
        
        int ans = 0;
        
        while(low<=high){
            int m = low + (high-low)/2;
            if(isOk(m, arr, k, n)){
                ans = m;
                low = m+1;
            }else{
                high = m-1;
            } 
        }
        
        return ans;
    }
};
