class Solution
{
    /*You are required to complete this method*/
    Node delete(Node head, int k)
    {
        // Initialize a counter to keep track of nodes visited
        int count = 1;
        // Initialize a pointer to traverse the list
        Node current = head;
        // Initialize a pointer to keep track of the previous node
        Node prev = null;

        // Traverse the list
        while (current != null) {
            // If the current node is the kth node, remove it
            if (count == k) {
                // If the previous node is null, it means we are removing the head
                if (prev == null) {
                    head = current.next; // Update the head
                } else {
                    prev.next = current.next; // Update the previous node's next pointer
                }
                // Reset the counter
                count = 1;
            } else {
                // Increment the counter
                count++;
                // Move the previous pointer to the current node
                prev = current;
            }
            // Move to the next node
            current = current.next;
        }
        return head;
    }
}
