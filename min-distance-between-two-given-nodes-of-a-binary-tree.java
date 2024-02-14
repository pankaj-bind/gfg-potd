class GfG {
    // Helper function to find the LCA of two nodes
    private Node findLCA(Node root, int a, int b) {
        if (root == null || root.data == a || root.data == b) {
            return root;
        }

        Node leftLCA = findLCA(root.left, a, b);
        Node rightLCA = findLCA(root.right, a, b);

        // If both nodes are found in different subtrees, then root is the LCA
        if (leftLCA != null && rightLCA != null) {
            return root;
        }

        // Otherwise, return the non-null LCA from the left or right subtree
        return (leftLCA != null) ? leftLCA : rightLCA;
    }

    // Helper function to find the distance from the root to a given node
    private int findDistance(Node root, int target, int distance) {
        if (root == null) {
            return -1;
        }

        if (root.data == target) {
            return distance;
        }

        int leftDistance = findDistance(root.left, target, distance + 1);
        int rightDistance = findDistance(root.right, target, distance + 1);

        // If the target node is not found in the current subtree, return -1
        if (leftDistance == -1 && rightDistance == -1) {
            return -1;
        }

        // Otherwise, return the distance from the root to the target node
        return (leftDistance != -1) ? leftDistance : rightDistance;
    }

    // Main function to find the minimum distance between two nodes
    int findDist(Node root, int a, int b) {
        // Find the Lowest Common Ancestor (LCA) of the two nodes
        Node lca = findLCA(root, a, b);

        // Calculate the distance from the LCA to each of the nodes
        int distanceA = findDistance(lca, a, 0);
        int distanceB = findDistance(lca, b, 0);

        // Return the total minimum distance
        return distanceA + distanceB;
    }
}
