class Solution {
    void matchPairs(int n, char nuts[], char bolts[]) {
        // code here
        char temp[]={'!','#','$','%','&','*','?','@','^'};
        Map<Character,Integer> mm = new HashMap<>();
        for(int i=0;i<n;i++)mm.put(nuts[i],1);
        int j=0;
        for(int i=0;i<9;i++){
            if(mm.get(temp[i])!=null){
                nuts[j]=temp[i];
                bolts[j]=temp[i];
                j++;
            }
        }
    }
}
