class Solution {
    public Node removeAllDuplicates(Node head) {
        // Create a dummy node to handle edge cases like removing head duplicates
        Node dummy = new Node(0);
        dummy.next = head;
        Node prev = dummy;
        Node curr = head;
        
        while (curr != null) {
            boolean isDuplicate = false;
            // Check for duplicates
            while (curr.next != null && curr.data == curr.next.data) {
                isDuplicate = true;
                curr = curr.next;
            }
            // If duplicates were found, skip all nodes with current value
            if (isDuplicate) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }
        return dummy.next;
    }
}
