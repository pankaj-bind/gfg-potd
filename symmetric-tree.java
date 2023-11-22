class GfG {
    // return true/false denoting whether the tree is Symmetric or not
    public static boolean isSymmetric(Node root) {
        if (root == null)
            return true; // Empty tree is symmetric

        return isSymmetricUtil(root.left, root.right);
    }

    private static boolean isSymmetricUtil(Node left, Node right) {
        // If both subtrees are empty, they are symmetric
        if (left == null && right == null)
            return true;

        // If one subtree is empty and the other is not, they are not symmetric
        if (left == null || right == null)
            return false;

        // Check if the values of the current nodes are equal
        // and if the left subtree's left child is equal to the right subtree's right child
        // and the left subtree's right child is equal to the right subtree's left child
        return (left.data == right.data) && isSymmetricUtil(left.left, right.right)
                && isSymmetricUtil(left.right, right.left);
    }
}