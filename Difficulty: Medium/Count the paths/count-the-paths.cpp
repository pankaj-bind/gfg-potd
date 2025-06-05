class Solution {
  public:
    int dfs(vector<vector<int>>& adjList, int node, int& dest, vector<int>& dp){
        if(node==dest) return 1;
        if(dp[node]!=-1) return dp[node];
        int ways=0;
        for(auto nbrNode:adjList[node]){  
            ways+=dfs(adjList, nbrNode, dest, dp);
        }
        return dp[node]=ways;
    }
    int countPaths(vector<vector<int>>& edges, int V, int src, int dest) {
        vector<vector<int>> adjList(V);
        for(auto& edge:edges){   // O(E)
            adjList[edge[0]].push_back(edge[1]);
        }
        vector<int> dp(V,-1);
        return dfs(adjList, src, dest, dp);  // O(V+E)
    }
};
