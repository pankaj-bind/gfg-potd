class Solution {
    int help(int i,int j,int n,int m,int a[],int b[],int dp[][],int diff){
	    if(i==n || j==m)return 0;
	    if(dp[i][j]!=-1)return dp[i][j];
	    int sum1=0,sum2=0;
	    if(diff!=0)
	    sum1 = help(i+1,j,n,m,a,b,dp,diff-1);
	    sum2 =a[i]*b[j]+help(i+1,j+1,n,m,a,b,dp,diff);
	    return dp[i][j] = Math.max(sum1,sum2);
	}
	public int maxDotProduct(int n, int m, int a[], int b[]) 
	{ 
		// Your code goes here
		int dp[][] = new int[n][m];
		for(int temp[]:dp){
		    Arrays.fill(temp,-1);
		}
		return help(0,0,n,m,a,b,dp,n-m);
	} 
}
