class Solution {
    public void deleteAlt(Node head) {
        // Edge case: if list is empty or contains only one node
        if (head == null || head.next == null) {
            return;
        }

        Node current = head;

        // Loop through the list and delete alternate nodes
        while (current != null && current.next != null) {
            // Skip the next node
            current.next = current.next.next;
            // Move to the next node in the list
            current = current.next;
        }
    }
}
