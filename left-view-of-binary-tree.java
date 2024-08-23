
class Tree {
    //Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        
        // Base case
        if (root == null) return result;

        // Create a queue for level-order traversal
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            // Number of nodes at the current level
            int size = queue.size();

            // Traverse all nodes of the current level
            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                // If it's the first node of the current level, add it to the result
                if (i == 0) {
                    result.add(currentNode.data);
                }

                // Add the left child of the current node to the queue
                if (currentNode.left != null) {
                    queue.add(currentNode.left);
                }

                // Add the right child of the current node to the queue
                if (currentNode.right != null) {
                    queue.add(currentNode.right);
                }
            }
        }
        
        return result;
    }
}
