class Solution {
    public static ArrayList<Integer> constructList(int q, int[][] queries) {
       // code here
       int x=0;
       ArrayList<Integer> ans = new ArrayList<>();
       for(int i=q-1;i>=0;i--){
           if(queries[i][0]==1)x^=queries[i][1];
           else ans.add(queries[i][1]^x);
       }
       ans.add(x);
       Collections.sort(ans);
       return ans;
   }
}