class Solution {
    // Return the root of the modified tree after removing all the half nodes.
    public Node RemoveHalfNodes(Node root) {
        // If root is null, return null
        if (root == null) {
            return null;
        }

        // Recursively process the left and right subtrees
        root.left = RemoveHalfNodes(root.left);
        root.right = RemoveHalfNodes(root.right);

        // If this is a half node with only left child, return the left child
        if (root.left != null && root.right == null) {
            return root.left;
        }

        // If this is a half node with only right child, return the right child
        if (root.left == null && root.right != null) {
            return root.right;
        }

        // If this is a full node or a leaf, return the node itself
        return root;
    }
}
