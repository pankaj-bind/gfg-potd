class Solution {
    public static int findShortestPath(int[][] mat) {
        // code here
       int r = mat.length, c = mat[0].length;
       int arr[][] = new int[r][c];
       for(int x[]:arr)Arrays.fill(x,1);
       int direRow[]={-1,0,1,0};
       int direCol[]={0,-1,0,1};
       for(int i=0;i<r;i++){
           for(int j=0;j<c;j++){
               if(mat[i][j]==0){
                   arr[i][j]=0;
                   for(int k=0;k<4;k++){
                       int nr = direRow[k]+i;
                       int nc = direCol[k]+j;
                       if(nr>=0 && nr<r && nc>=0 && nc<c){
                           arr[nr][nc]=0;
                       }
                   }
               }
           }
       }
       Queue<int[]> q = new LinkedList<>();
       int vis[][] = new int[r][c];
       for(int x[]:vis)Arrays.fill(x,0);
       for(int i=0;i<r;i++){
           if(arr[i][0]==1)q.add(new int[]{1,i,0});
       }
       while(!q.isEmpty()){
           int[] temp = q.poll();
           int i = temp[1];
           int j = temp[2];
           int dis = temp[0];
           vis[i][j]=1;
           if(j==c-1)return dis;
           for(int k=0;k<4;k++){
               int nr = direRow[k]+i;
               int nc = direCol[k]+j;
               if(nr>=0 && nr<r && nc>=0 && nc<c && vis[nr][nc]==0 && arr[nr][nc]==1){
                   q.add(new int[]{dis+1,nr,nc});
               }
           }
       }
       return -1;
    }
}
