class Solution
{
    //Function to find sum of all possible substrings of the given string.
    public static long sumSubstrings(String s)
    {
    //Your code here
        long ans=0,previous=0,mod=1000000007;
        for(int i=0;i<s.length();i++){
            long curr = (previous*10)%mod+(s.charAt(i)-'0')*(i+1)%mod;
            previous=curr;
            ans=(ans+curr)%mod;
        }
        return ans;
    }
}