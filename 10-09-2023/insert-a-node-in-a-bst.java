class Solution {
    // Function to insert a node in a BST.
    Node insert(Node root, int Key) {
        // If the tree is empty, create a new node and return it
        if (root == null) {
            return new Node(Key);
        }

        // Otherwise, recur down the tree
        if (Key < root.data) {
            root.left = insert(root.left, Key);
        } else if (Key > root.data) {
            root.right = insert(root.right, Key);
        }

        // return the unchanged node pointer
        return root;
    }
}