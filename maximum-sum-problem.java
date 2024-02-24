class Solution
{
    public int maxSum(int n) 
    { 
        if(n==0 || n==1){
            return n;
        }
        
        return Math.max(maxSum(n/2)+maxSum(n/3)+maxSum(n/4),n);
    } 
}