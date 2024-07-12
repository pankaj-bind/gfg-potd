class Solution {
    /* you are required to complete this function */
    boolean hasPathSum(Node root, int target) {
        if (root == null) {
            return false;
        }
        
        // If this is a leaf node, check if the current sum equals the target
        if (root.left == null && root.right == null) {
            return root.data == target;
        }
        
        // Subtract the current node's value from the target and check the subtrees
        int newTarget = target - root.data;
        return hasPathSum(root.left, newTarget) || hasPathSum(root.right, newTarget);
    }
}
