class Solution
{
    ArrayList<Integer> nodesList;

    // Helper method to perform inorder traversal
    void inorderTraversal(Node root) {
        if (root == null)
            return;
        
        inorderTraversal(root.left);
        nodesList.add(root.data);
        inorderTraversal(root.right);
    }

    // Helper method to build a BST from sorted elements
    Node buildBST(int left, int right) {
        if (left > right)
            return null;

        int mid = (left + right) / 2;
        Node newNode = new Node(nodesList.get(mid));

        newNode.left = buildBST(left, mid - 1);
        newNode.right = buildBST(mid + 1, right);

        return newNode;
    }

    // The given root is the root of the Binary Tree
    // Return the root of the generated BST
    Node binaryTreeToBST(Node root)
    {
        // Step 1: Initialize the list to store nodes
        nodesList = new ArrayList<>();

        // Step 2: Perform inorder traversal
        inorderTraversal(root);

        // Step 3: Sort the list in ascending order
        Collections.sort(nodesList);

        // Step 4: Build a BST using sorted elements
        return buildBST(0, nodesList.size() - 1);
    }
}

 