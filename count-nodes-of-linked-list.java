class Solution {
    // Function to count nodes of a linked list.
    public int getCount(Node head) {
        int count = 0;
        Node current = head;
        
        // Traverse the linked list and count the nodes
        while (current != null) {
            count++;
            current = current.next;
        }
        
        return count;
    }
}
