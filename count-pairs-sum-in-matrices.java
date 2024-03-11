class Solution {
    int countPairs(int mat1[][], int mat2[][], int n, int x) {
       int count=0;
       HashSet<Integer> set1=new HashSet<>();
       
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               set1.add(mat1[i][j]);
           }
       }
       for(int i=0;i<n;i++){
           for(int j=0;j<n;j++){
               if(set1.contains(x-mat2[i][j])){
                   count++;
               }
           }
       }
       return count;
    }
}