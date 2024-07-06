class Solution {
    Node prev = null;

    public void populateNext(Node root) {
        if (root == null) return;

        // Inorder traversal: left, root, right
        populateNext(root.left);

        if (prev != null) {
            prev.next = root;
        }
        prev = root;

        populateNext(root.right);
    }
}
