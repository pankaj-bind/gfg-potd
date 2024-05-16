class Solution {
    static int ans=0;
    int help(ArrayList<ArrayList<Integer>> adj,int vis[],int node){
        vis[node]=1;
        int size=1;
        for(int x:adj.get(node)){
            if(vis[x]==0){
                int temp = help(adj,vis,x);
                size+=temp;
                if(temp%2==0)ans++;
            }
        }
        return size;
    }
    public int minimumEdgeRemove(int n, int[][] edges) {
        // code here
        ans=0;
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>();
        for(int i=0;i<=n;i++) {
            adj.add(new ArrayList<>());
        }
        for(int x[]:edges){
            adj.get(x[0]).add(x[1]);
            adj.get(x[1]).add(x[0]);
        }
	    int vis[] = new int[n+1];
	    Arrays.fill(vis,0);
	    for(int i=1;i<=n;i++){
	        if(vis[i]==0){
	            int temp = help(adj,vis,i);
	        }
	    }
	    return ans;
    }
}