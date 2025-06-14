/*
class Node {
public:
    int data;
    Node *left, *right;

    Node(int val) {
        data = val;
        left = right = nullptr;
    }
};
*/

class Solution {
  public:
    // Helper function to check if two trees are mirrors
    bool isMirror(Node* t1, Node* t2) {
        if (!t1 && !t2) return true;             // Both are null
        if (!t1 || !t2) return false;            // One is null, the other isn't
        if (t1->data != t2->data) return false;  // Data doesn't match

        // Check the mirror condition recursively
        return isMirror(t1->left, t2->right) && isMirror(t1->right, t2->left);
    }

    bool isSymmetric(Node* root) {
        if (!root) return true; // An empty tree is symmetric
        return isMirror(root->left, root->right);
    }
};
