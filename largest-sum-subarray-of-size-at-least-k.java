class Solution {
    
    public long maxSumWithK(long a[], long n, long k)
    {
        long ans=Integer.MIN_VALUE,sum1=0,sum2=0;
        int j=0;
        for(int i=0;i<n;i++){
            sum1+=a[i];
            if(i-j+1==k){
                ans=Math.max(sum1,ans);
            }
            else if(i-j+1>k){
                sum2+=a[j++];
                if(sum2<0){
                    sum1-=sum2;
                    sum2=0;
                }
                ans=Math.max(ans,sum1);
            }
        }
        return ans;
    }
}
