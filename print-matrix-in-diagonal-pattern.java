class Solution {
    public int[] matrixDiagonally(int[][] mat) {
         int row=0,col=0,n=mat.length;
         boolean isReverse=false;
         int ans[] = new int[n*n];
         int index=0;
         while(col<n){
             ArrayList<Integer> temp = new ArrayList<>();
             int i=row,j=col;
             while(i<n && j<n && i>=0 && j>=0){
                 temp.add(mat[i][j]);
                 i--;
                 j++;
             }
             if(isReverse)Collections.reverse(temp);
             for(int k=0;k<temp.size();k++){
                 ans[index++]=temp.get(k);
             }
             if(row!=n-1){
                 row++;
                 col=0;
             }
             else{
                 col++;
             }
             isReverse=!isReverse;
         }
         return ans;
    }
};