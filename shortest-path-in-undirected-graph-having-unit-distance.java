
class Solution {
    
    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        // Create adjacency list representation of the graph
        List<List<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adjList.add(new ArrayList<>());
        }
        
        // Fill the adjacency list
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adjList.get(u).add(v);
            adjList.get(v).add(u); // because it's an undirected graph
        }
        
        // Distance array to store shortest distance to each node
        int[] dist = new int[n];
        Arrays.fill(dist, -1);  // Initialize distances as -1 (unreachable)
        
        // BFS queue
        Queue<Integer> queue = new LinkedList<>();
        
        // Initialize BFS starting from source
        dist[src] = 0;  // Distance to source is 0
        queue.add(src);
        
        // Perform BFS
        while (!queue.isEmpty()) {
            int node = queue.poll();
            
            // Explore all neighbors
            for (int neighbor : adjList.get(node)) {
                if (dist[neighbor] == -1) {  // If the neighbor is not visited
                    dist[neighbor] = dist[node] + 1;
                    queue.add(neighbor);
                }
            }
        }
        
        return dist;
    }
}
