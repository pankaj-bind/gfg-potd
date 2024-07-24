// User function Template for Java

class Solution {
    // Variable to keep track of the previous node in the in-order traversal
    Node prev;

    // Function to check whether a Binary Tree is BST or not.
    boolean isBST(Node root) {
        // Initialize the prev node to null
        prev = null;
        // Call the recursive helper function
        return isBSTUtil(root);
    }

    // Helper function to perform in-order traversal and check the BST property
    boolean isBSTUtil(Node node) {
        // Base case: if the node is null, return true
        if (node == null) {
            return true;
        }

        // Recursively check the left subtree
        if (!isBSTUtil(node.left)) {
            return false;
        }

        // Check the current node with the previous node
        if (prev != null && node.data <= prev.data) {
            return false;
        }

        // Update the previous node to the current node
        prev = node;

        // Recursively check the right subtree
        return isBSTUtil(node.right);
    }
}
