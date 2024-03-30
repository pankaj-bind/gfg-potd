class Solution {
    // Function to find the minimum element in the given BST.
    int minValue(Node root) {
        if (root == null)
            return -1; // Return -1 if the tree is empty
        
        // Traverse to the leftmost node
        while (root.left != null)
            root = root.left;
        
        return root.data; // Return the data of the leftmost node
    }
}
