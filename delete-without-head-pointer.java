//Function to delete a node without any reference to head pointer.
class Solution
{
    void deleteNode(Node del_node)
    {
        // Copy the value of the next node to the node to be deleted.
        del_node.data = del_node.next.data;
        
        // Point the next pointer of the node to be deleted to the next of the next node.
        del_node.next = del_node.next.next;
    }
}
