class Solution  
{ 
    // Helper function to check if two trees are isomorphic
    boolean areIsomorphicUtil(Node n1, Node n2) {
        // If both nodes are null, they are isomorphic
        if (n1 == null && n2 == null) {
            return true;
        }
        
        // If one of the nodes is null, they are not isomorphic
        if (n1 == null || n2 == null) {
            return false;
        }
        
        // Check if the current nodes have the same value and
        // if their left subtrees and right subtrees are isomorphic
        return (n1.data == n2.data) &&
               ((areIsomorphicUtil(n1.left, n2.left) && areIsomorphicUtil(n1.right, n2.right)) ||
                (areIsomorphicUtil(n1.left, n2.right) && areIsomorphicUtil(n1.right, n2.left)));
    }
    
    // Main function to check if two trees are isomorphic
    boolean isIsomorphic(Node root1, Node root2)  
    { 
        return areIsomorphicUtil(root1, root2);
    }
}
