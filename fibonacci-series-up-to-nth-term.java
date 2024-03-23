class Solution {

    int[] Series(int n) {
        // code here
        int[] ans=new int[n+1];
        int mod=1000000007;
        
        ans[0]=0;
        ans[1]=1;
        for(int i=2; i<=n;i++){
            int temp=ans[i-1]+ans[i-2];
            ans[i]=temp%mod;
            
        }
        
        return ans;
    }
}