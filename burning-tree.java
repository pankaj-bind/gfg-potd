class Solution
{
    // Helper function to map nodes to their parents and locate the target node.
    private static Node mapParents(Node root, int target, Map<Node, Node> parentMap) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        Node targetNode = null;
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            
            // If we find the target node, store it.
            if (current.data == target) {
                targetNode = current;
            }
            
            // Store parents while traversing
            if (current.left != null) {
                parentMap.put(current.left, current);
                queue.add(current.left);
            }
            
            if (current.right != null) {
                parentMap.put(current.right, current);
                queue.add(current.right);
            }
        }
        
        return targetNode;
    }
    
    public static int minTime(Node root, int target) 
    {
        // Map to store parent relationships
        Map<Node, Node> parentMap = new HashMap<>();
        
        // Get the target node and build parent relationships
        Node targetNode = mapParents(root, target, parentMap);
        
        // BFS to simulate burning process
        Queue<Node> queue = new LinkedList<>();
        Set<Node> visited = new HashSet<>();
        
        queue.add(targetNode);
        visited.add(targetNode);
        
        int time = 0;
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean anyBurnt = false;
            
            for (int i = 0; i < size; i++) {
                Node current = queue.poll();
                
                // Check left child
                if (current.left != null && !visited.contains(current.left)) {
                    queue.add(current.left);
                    visited.add(current.left);
                    anyBurnt = true;
                }
                
                // Check right child
                if (current.right != null && !visited.contains(current.right)) {
                    queue.add(current.right);
                    visited.add(current.right);
                    anyBurnt = true;
                }
                
                // Check parent
                Node parent = parentMap.get(current);
                if (parent != null && !visited.contains(parent)) {
                    queue.add(parent);
                    visited.add(parent);
                    anyBurnt = true;
                }
            }
            
            // If any node was burnt, increase the time
            if (anyBurnt) {
                time++;
            }
        }
        
        return time;
    }
}
