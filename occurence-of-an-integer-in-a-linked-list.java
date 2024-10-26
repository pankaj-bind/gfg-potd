class Solution {
    public static int count(Node head, int key) {
        int count = 0;  // Initialize counter
        Node current = head;
        
        while (current != null) {  // Traverse the linked list
            if (current.data == key) {  // If the current node data matches key
                count++;  // Increment counter
            }
            current = current.next;  // Move to the next node
        }
        
        return count;  // Return the final count
    }
}
