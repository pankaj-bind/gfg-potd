class Solution {
    public List<Integer> shortestPath(int n, int m, int edges[][]) {
        // Create an adjacency list to represent the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int i = 1; i <= n; i++) {
            graph.put(i, new ArrayList<>());
        }
        for (int[] edge : edges) {
            graph.get(edge[0]).add(new int[]{edge[1], edge[2]});
            graph.get(edge[1]).add(new int[]{edge[0], edge[2]});
        }

        // Priority queue to store the nodes with their current shortest distance from the source
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[1]));
        pq.add(new int[]{1, 0});
        
        // Distance array to store the shortest distance from the source to each node
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;
        
        // Parent array to reconstruct the shortest path
        int[] parent = new int[n + 1];
        Arrays.fill(parent, -1);
        
        while (!pq.isEmpty()) {
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            
            if (d > dist[u]) continue;
            
            for (int[] neighbor : graph.get(u)) {
                int v = neighbor[0];
                int weight = neighbor[1];
                
                if (dist[u] + weight < dist[v]) {
                    dist[v] = dist[u] + weight;
                    pq.add(new int[]{v, dist[v]});
                    parent[v] = u;
                }
            }
        }
        
        List<Integer> result = new ArrayList<>();
        if (dist[n] == Integer.MAX_VALUE) {
            result.add(-1);
        } else {
            result.add(dist[n]);
            LinkedList<Integer> path = new LinkedList<>();
            for (int at = n; at != -1; at = parent[at]) {
                path.addFirst(at);
            }
            result.addAll(path);
        }
        
        return result;
    }
}
