
class Solution {
    public static int minimumCost(int n, int w, int[] cost) {
        // code here
        int dp[] = new int[w+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        for(int i=0;i<n;i++){
            if(cost[i]!=-1){
                for(int j=i+1;j<=w;j++){
                    dp[j]=Math.min(dp[j],cost[i]+dp[j-i-1]);
                }
            }
        }
        return dp[w]!=Integer.MAX_VALUE?dp[w]:-1;
    }
}
