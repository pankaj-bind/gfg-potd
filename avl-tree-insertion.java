class Solution
{
    // Helper function to calculate height of a node
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Helper function to perform left rotation
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        y.left = x;
        x.right = T2;

        x.height = Math.max(height(x.left), height(x.right)) + 1;
        y.height = Math.max(height(y.left), height(y.right)) + 1;

        return y;
    }

    // Helper function to perform right rotation
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        x.right = y;
        y.left = T2;

        y.height = Math.max(height(y.left), height(y.right)) + 1;
        x.height = Math.max(height(x.left), height(x.right)) + 1;

        return x;
    }

    // Helper function to get balance factor of a node
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Helper function to balance the tree after an insertion
    Node balance(Node root, int data) {
        // Update height of current node
        root.height = Math.max(height(root.left), height(root.right)) + 1;

        // Get the balance factor
        int balance = getBalance(root);

        // Left Left Case
        if (balance > 1 && data < root.left.data)
            return rightRotate(root);

        // Right Right Case
        if (balance < -1 && data > root.right.data)
            return leftRotate(root);

        // Left Right Case
        if (balance > 1 && data > root.left.data) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }

        // Right Left Case
        if (balance < -1 && data < root.right.data) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }

        return root;
    }

    // Insert a node into the AVL tree
    public Node insertToAVL(Node root, int data) {
        // Perform standard BST insertion
        if (root == null)
            return new Node(data);

        if (data < root.data)
            root.left = insertToAVL(root.left, data);
        else if (data > root.data)
            root.right = insertToAVL(root.right, data);
        else // Duplicate data not allowed
            return root;

        // Update height of current node
        root.height = 1 + Math.max(height(root.left), height(root.right));

        // Balance the tree
        return balance(root, data);
    }
}
