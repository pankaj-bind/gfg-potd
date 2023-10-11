class Tree
{
    int getHeight(Node root) {
        if (root == null)
            return 0;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        return Math.max(leftHeight, rightHeight) + 1;
    }
    
    boolean isBalanced(Node root)
    {
        if (root == null)
            return true;
        
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        
        if (Math.abs(leftHeight - rightHeight) <= 1 && 
            isBalanced(root.left) && isBalanced(root.right))
            return true;
        
        return false;
    }
}
