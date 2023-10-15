class GfG
{
    // Perform in-order traversal and return a list of sorted nodes
    List<Node> sortedNodes = new ArrayList<>();

    void inOrderTraversal(Node node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);
        sortedNodes.add(node);
        inOrderTraversal(node.right);
    }

    // Build a balanced BST from the sorted nodes
    Node buildBalancedTree(int start, int end) {
        if (start > end)
            return null;

        int mid = (start + end) / 2;
        Node node = sortedNodes.get(mid);

        node.left = buildBalancedTree(start, mid - 1);
        node.right = buildBalancedTree(mid + 1, end);

        return node;
    }

    Node buildBalancedTree(Node root) 
    {
        // Step 1: Perform in-order traversal
        inOrderTraversal(root);

        // Step 2: Build balanced BST from sorted nodes
        int n = sortedNodes.size();
        return buildBalancedTree(0, n - 1);
    }
}