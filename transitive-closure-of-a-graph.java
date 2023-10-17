class Solution{
    static ArrayList<ArrayList<Integer>> transitiveClosure(int n, int graph[][])
    {
       int[][] adj = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (graph[i][j] == 1 && i != j) {
                    adj[i][j] = 1;
                }
            }
        }
        
        //  for (int i = 0; i < n; i++) {
        //     for (int j = 0; j < n; j++) {
        //         System.out.print(adj[i][j] +" ");
        //      }
        //       System.out.println();
        //  }

        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            ans.add(new ArrayList<>(n));
            for (int j = 0; j < n; j++) {
                ans.get(i).add(0);
            }
        }

        for (int i = 0; i < n; i++) {
            dfs(i, i, adj, ans);
        }
        return ans;
    }

    static void dfs(int i, int j, int[][] adj,  ArrayList<ArrayList<Integer>> ans) {
        ans.get(i).set(j, 1);
        for (int it = 0; it < adj[j].length; it++) {
            if (adj[j][it] == 1 && ans.get(i).get(it) == 0) {
                dfs(i, it, adj, ans);
            }
        }
    }

}