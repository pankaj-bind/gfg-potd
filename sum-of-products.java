class Solution {
    static long pairAndSum(int n, long arr[]) {
        // code here
        int bits[] = new int[32];
        Arrays.fill(bits,0);
        for(int i=0;i<n;i++){
            long temp = arr[i];
            int j=0;
            while(temp!=0){
                if((temp&1)==1)bits[j]++;
                temp>>=1;
                j++;
            }
        }
        long ans = 0;
        for(int i=0;i<32;i++){
            long temp = bits[i];
            temp--;
            long pairs = (temp*(temp+1))/2;
            ans+=(pairs*(long)Math.pow(2,i));
        }
        return ans;
    }
}