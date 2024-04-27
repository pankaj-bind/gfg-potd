class Solution {
    Node deleteMid(Node head) {
        if (head == null || head.next == null) {
            // If the list is empty or contains a single node, return null
            return null;
        }
        
        Node slow = head;
        Node fast = head;
        Node prev = null;
        
        // Traverse the list with slow and fast pointers
        while (fast != null && fast.next != null) {
            // Move slow one step at a time
            prev = slow;
            slow = slow.next;
            // Move fast two steps at a time
            fast = fast.next.next;
        }
        
        // Delete the middle node
        prev.next = slow.next;
        
        return head;
    }
}
