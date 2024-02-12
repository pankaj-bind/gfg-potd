class Solution {
    // Helper function for DFS traversal to clone the graph
    private Node cloneGraphDFS(Node node, HashMap<Node, Node> visited) {
        // If the node is already visited, return the cloned node
        if (visited.containsKey(node)) {
            return visited.get(node);
        }

        // Create a new node for the current original node
        Node cloneNode = new Node(node.val, new ArrayList<>());
        visited.put(node, cloneNode);

        // Iterate through the neighbors of the original node and clone them recursively
        for (Node neighbor : node.neighbors) {
            cloneNode.neighbors.add(cloneGraphDFS(neighbor, visited));
        }

        return cloneNode;
    }

    // Main function to clone the graph
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        // HashMap to store mapping of original nodes to cloned nodes
        HashMap<Node, Node> visited = new HashMap<>();

        // Clone the graph using DFS
        Node clonedGraph = cloneGraphDFS(node, visited);

        return clonedGraph;
    }
}
