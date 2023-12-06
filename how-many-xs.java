class Solution {
    int countX(int L, int R, int X) {
        int counter =0;
        for(int i=L+1; i<R; i++){
            int temp = i;
            while(temp>0){
                int mod = temp%10;
                if(mod==X)counter++;
                temp/=10;
            }
        }
        return counter;
    }
};