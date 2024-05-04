class GfG
{
    // Helper function to construct the tree recursively
    Node buildTreeUtil(int in[], int post[], int inStart, int inEnd, int postStart, int postEnd) {
        if (inStart > inEnd || postStart > postEnd) {
            return null;
        }

        // The last element in postorder traversal is the root
        Node root = new Node(post[postEnd]);

        // Find the index of root in inorder traversal
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (in[i] == root.data) {
                inIndex = i;
                break;
            }
        }

        // Recursively build left and right subtrees
        root.left = buildTreeUtil(in, post, inStart, inIndex - 1, postStart, postStart + inIndex - inStart - 1);
        root.right = buildTreeUtil(in, post, inIndex + 1, inEnd, postStart + inIndex - inStart, postEnd - 1);

        return root;
    }

    //Function to return a tree created from postorder and inorder traversals.
    Node buildTree(int in[], int post[], int n) {
        // Call the helper function with appropriate indices
        return buildTreeUtil(in, post, 0, n - 1, 0, n - 1);
    }
}
