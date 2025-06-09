/*The Node structure is
class Node
{
    int data;
    struct Node *left;
    struct Node *right;

    Node(int x){
        data = x;
        left = NULL;
        right = NULL;
    }
};*/

class Solution {
  public:
    bool isDeadEndUtil(Node* root, int min, int max) {
    if (!root) return false;

    // Dead end condition
    if (min == max) return true;

    // Check in left and right subtrees
    return isDeadEndUtil(root->left, min, root->data - 1) ||
           isDeadEndUtil(root->right, root->data + 1, max);
}

bool isDeadEnd(Node *root) {
    return isDeadEndUtil(root, 1, INT_MAX);
}

};