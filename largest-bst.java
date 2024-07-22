class Solution {
    
    static class Info {
        int size;   // Size of the subtree
        int min;    // Minimum value in the subtree
        int max;    // Maximum value in the subtree
        boolean isBST; // Is the subtree a BST

        Info(int size, int min, int max, boolean isBST) {
            this.size = size;
            this.min = min;
            this.max = max;
            this.isBST = isBST;
        }
    }
    
    static int largestBst(Node root) {
        Info info = largestBSTUtil(root);
        return info.size;
    }

    static Info largestBSTUtil(Node node) {
        // Base case: An empty tree is a BST of size 0.
        if (node == null) {
            return new Info(0, Integer.MAX_VALUE, Integer.MIN_VALUE, true);
        }
        
        // Recur for left and right subtrees
        Info left = largestBSTUtil(node.left);
        Info right = largestBSTUtil(node.right);
        
        // Initialize the current node's min and max values
        int min = Math.min(node.data, Math.min(left.min, right.min));
        int max = Math.max(node.data, Math.max(left.max, right.max));
        
        // Check if the current node is a BST
        if (left.isBST && right.isBST && left.max < node.data && node.data < right.min) {
            // Current subtree is a BST
            return new Info(left.size + right.size + 1, min, max, true);
        }
        
        // If not a BST, return the larger size of the left or right subtree
        return new Info(Math.max(left.size, right.size), min, max, false);
    }
}
