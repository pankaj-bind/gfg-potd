// User function Template for Java
class Solution {
    static int numberOfConsecutiveOnes(int n) {
        // code here        \
        if(n==2)return 1;
        int ans=1,a=0,b=1,mod=1000000007;
        for(int i=3;i<=n;i++){
            int c=(a+b)%mod;
            a=b;
            b=c;
            ans=((ans*2)%mod+c)%mod;
        }
        return ans;
    }
}
