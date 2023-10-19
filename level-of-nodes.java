class Solution
{
    // Function to find the level of node X.
    int nodeLevel(int V, ArrayList<ArrayList<Integer>> adj, int X)
    {
        // Create an array to keep track of visited nodes.
        boolean[] visited = new boolean[V];
        
        // Create a queue for BFS and add the starting node to it.
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        
        // Initialize level to 0.
        int level = 0;
        
        // Perform BFS.
        while (!queue.isEmpty()) {
            int size = queue.size();
            level++;
            
            // Process all nodes at the current level.
            for (int i = 0; i < size; i++) {
                int u = queue.poll();
                
                // Check if u is the target node X.
                if (u == X)
                    return level - 1; // Return the level - 1 (since level is incremented after processing).
                
                // Visit all adjacent nodes of u.
                for (int v : adj.get(u)) {
                    if (!visited[v]) {
                        visited[v] = true;
                        queue.add(v);
                    }
                }
            }
        }
        
        // If X is not found, return -1.
        return -1;
    }
}