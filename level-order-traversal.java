class Solution {
    // Function to return the level order traversal of a tree.
    static ArrayList<Integer> levelOrder(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null)
            return result;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node current = queue.poll();
            result.add(current.data);
            
            if (current.left != null)
                queue.add(current.left);
            if (current.right != null)
                queue.add(current.right);
        }
        
        return result;
    }
}