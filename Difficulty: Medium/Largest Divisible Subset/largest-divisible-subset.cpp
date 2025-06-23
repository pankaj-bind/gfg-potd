class Solution {
  public:
    vector<int> largestSubset(vector<int>& arr) {
        int n=arr.size();
        sort(arr.begin(),arr.end());
        vector<int>dp(n,0);
        int ans=0;
        int prev=0;
        for(int i=n-2;i>=0;i--)
        {
            for(int j=n-1;j>i;j--)
            {
                if(arr[j]%arr[i]==0)
                {
                    dp[i]=max(dp[j]+1,dp[i]);
                    if(dp[i]>ans)
                    {
                    ans=max(ans,dp[i]);
                    prev=arr[i];
                    }
                }
            }
        }
       
        int j=0;
        for(int i=0;i<n;i++)
        {
            if(dp[i]==ans)
            {
                prev=arr[i];
                j=i+1;
            }
        }
        vector<int>res;
        res.push_back(prev);
        --ans;
         while(ans>=0)
         {   
            int l=0;
            for(int k=j;k<n;k++)
            {   
                
                
                if(dp[k]==ans && arr[k]%prev==0)
                {
                    
                   
                    l=k+1;
                }
               
                
            }
            res.push_back(arr[l-1]);
            prev=arr[l-1];
            j=l;
            --ans;
         }
        
        return res;
    }
};
