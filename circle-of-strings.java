class Solution {
    public int isCircle(String arr[]) {
        // Create maps for in-degrees and out-degrees
        Map<Character, Integer> inDegree = new HashMap<>();
        Map<Character, Integer> outDegree = new HashMap<>();
        
        // Create adjacency list for graph representation
        Map<Character, Set<Character>> adjList = new HashMap<>();
        
        for (String s : arr) {
            char start = s.charAt(0);
            char end = s.charAt(s.length() - 1);
            
            outDegree.put(start, outDegree.getOrDefault(start, 0) + 1);
            inDegree.put(end, inDegree.getOrDefault(end, 0) + 1);
            
            adjList.putIfAbsent(start, new HashSet<>());
            adjList.get(start).add(end);
            adjList.putIfAbsent(end, new HashSet<>());
        }
        
        // Check in-degree and out-degree
        for (Character c : outDegree.keySet()) {
            if (!inDegree.containsKey(c) || !inDegree.get(c).equals(outDegree.get(c))) {
                return 0;
            }
        }
        
        // Check strong connectivity
        Set<Character> vertices = new HashSet<>(adjList.keySet());
        if (vertices.isEmpty()) {
            return 1; // Empty case
        }
        
        if (!isStronglyConnected(vertices, adjList)) {
            return 0;
        }
        
        return 1;
    }

    private boolean isStronglyConnected(Set<Character> vertices, Map<Character, Set<Character>> adjList) {
        // Check if the graph is strongly connected using DFS
        
        // 1. Check reachability from any vertex
        Character startVertex = vertices.iterator().next();
        Set<Character> reachable = new HashSet<>();
        dfs(startVertex, adjList, reachable);
        
        // If all vertices are reachable from startVertex
        if (reachable.size() != vertices.size()) {
            return false;
        }
        
        // 2. Check if all vertices can reach startVertex using reversed graph
        Map<Character, Set<Character>> reverseAdjList = reverseGraph(adjList);
        reachable.clear();
        dfs(startVertex, reverseAdjList, reachable);
        
        // If all vertices can reach startVertex in reversed graph
        return reachable.size() == vertices.size();
    }

    private Map<Character, Set<Character>> reverseGraph(Map<Character, Set<Character>> adjList) {
        Map<Character, Set<Character>> reverseAdjList = new HashMap<>();
        
        for (Character vertex : adjList.keySet()) {
            for (Character neighbor : adjList.get(vertex)) {
                reverseAdjList.putIfAbsent(neighbor, new HashSet<>());
                reverseAdjList.get(neighbor).add(vertex);
            }
        }
        
        return reverseAdjList;
    }

    private void dfs(Character start, Map<Character, Set<Character>> adjList, Set<Character> reachable) {
        Stack<Character> stack = new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()) {
            Character v = stack.pop();
            if (!reachable.contains(v)) {
                reachable.add(v);
                if (adjList.containsKey(v)) {
                    for (Character neighbor : adjList.get(v)) {
                        if (!reachable.contains(neighbor)) {
                            stack.push(neighbor);
                        }
                    }
                }
            }
        }
    }
}
