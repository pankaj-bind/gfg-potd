class Solution{
    static long mod=1000000007;
    static long sequence(int n){
         long ans = 0;
         long aa = 1;
        for(int i=0; i<n;i++){
           long a =1;
           for(int j = 0; j<=i; j++){
               a *= aa;
               a %=mod;
               aa = aa+1;
           }
           ans += a;
           ans %= mod;
        }
        return ans;
    }
}