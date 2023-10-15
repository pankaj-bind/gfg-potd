class GfG {
    // Initialize an index to keep track of the sorted nodes
    int index = 0;

    Node buildBalancedTree(Node root) {
        // Count the number of nodes in the tree
        int n = countNodes(root);
        
        // Initialize the index to 0
        index = 0;
        
        // Build the balanced BST
        return buildBalancedTree(root, n);
    }

    // Helper function to count nodes in the tree
    int countNodes(Node node) {
        if (node == null)
            return 0;

        return countNodes(node.left) + 1 + countNodes(node.right);
    }

    // Build the balanced BST from the sorted nodes
    Node buildBalancedTree(Node root, int n) {
        if (n <= 0)
            return null;

        // Recursively build the left subtree
        Node left = buildBalancedTree(root, n / 2);

        // Create the current node
        Node node = new Node(root.data);

        // Move to the next index
        index++;

        // Recursively build the right subtree
        Node right = buildBalancedTree(root, n - n / 2 - 1);

        // Set the left and right children
        node.left = left;
        node.right = right;

        return node;
    }
}
