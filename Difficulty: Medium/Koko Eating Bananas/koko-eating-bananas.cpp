class Solution {
  public:
  bool ispossible(vector<int>& arr,int mid,int k){
      int count=0;
      for(int i=0;i<arr.size();i++){
          count+=arr[i]/mid;
          if(arr[i]%mid)
          count++;
      }
     if(count<=k) return true;
     else  return false;
  }
    int kokoEat(vector<int>& arr, int k) {
        // Code here
        int start=1;
        int end=arr[0];
        int n=arr.size();
        int mid;
        int ans;
        for(int i=1;i<n;i++){
            start=min(arr[i],start);
            end=max(arr[i],end);
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            if(ispossible(arr,mid,k)){
                ans=mid;
                end=mid-1;
            }
            else{
                start=mid+1;
            }
        }
        return ans;
    }
};
