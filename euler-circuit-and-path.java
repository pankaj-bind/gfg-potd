class Solution {
    public int isEulerCircuit(int V, List<Integer>[] adj) {
        // Step 1: Count degrees of all vertices
        int[] degree = new int[V];
        for (int i = 0; i < V; i++) {
            degree[i] = adj[i].size();
        }

        // Step 2: Check for odd degrees
        int oddDegreeCount = 0;
        for (int i = 0; i < V; i++) {
            if (degree[i] % 2 != 0) {
                oddDegreeCount++;
            }
        }

        // Step 3: If any vertex has odd degree, return 0
        if (oddDegreeCount > 2 || oddDegreeCount == 1) {
            return 0;
        }

        // Step 4: Check for connected graph
        boolean[] visited = new boolean[V];
        dfs(adj, 0, visited);

        for (int i = 0; i < V; i++) {
            if (!visited[i] && degree[i] > 0) {
                return 0; // If not connected, return 0
            }
        }

        // Step 5: Determine the result based on oddDegreeCount
        return (oddDegreeCount == 2) ? 1 : 2;
    }

    // Depth First Search to check connectivity
    private void dfs(List<Integer>[] adj, int vertex, boolean[] visited) {
        visited[vertex] = true;

        for (int neighbor : adj[vertex]) {
            if (!visited[neighbor]) {
                dfs(adj, neighbor, visited);
            }
        }
    }
}
