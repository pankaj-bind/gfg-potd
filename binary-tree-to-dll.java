class Solution
{
    Node prev = null;  // To store the previously visited node
    Node head = null;  // To store the head of the DLL

    // Function to convert binary tree to doubly linked list and return it.
    Node bToDLL(Node root)
    {
        // Base case
        if (root == null) return null;

        // Recursively convert the left subtree
        bToDLL(root.left);

        // Now, process the current node
        if (prev == null) {
            // This is the leftmost node, which will be the head of the DLL
            head = root;
        } else {
            // Link the previous node with the current node
            root.left = prev;
            prev.right = root;
        }

        // Move the prev pointer to the current node
        prev = root;

        // Recursively convert the right subtree
        bToDLL(root.right);

        return head;  // Return the head of the doubly linked list
    }
}
