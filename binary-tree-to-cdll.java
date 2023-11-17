class Solution
{ 
    //Function to convert binary tree into circular doubly linked list.
     Node head = null, prev = null;
    Node bTreeToClist(Node root)
    {
         inorder(root);

        // fixing the last node
        head.left = prev;
        prev.right = head;

        return head;
    }

    void inorder(Node curr) {
        if (curr == null)
            return;

        inorder(curr.left);

        if (head == null)
            head = prev = curr;
        else {
            prev.right = curr;
            curr.left = prev;
        }

        // before moving right update prev to curr.
        prev = curr;
        inorder(curr.right);
    }
    
}
