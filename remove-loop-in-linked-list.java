class Solution {
    // Function to remove a loop in the linked list.
    public static void removeLoop(Node head) {
        if (head == null || head.next == null) return;

        Node slow = head, fast = head;

        // Detect loop using Floyd’s Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Loop detected
            if (slow == fast) {
                removeLoopHelper(head, slow);
                return;
            }
        }
    }

    // Helper function to remove the loop
    private static void removeLoopHelper(Node head, Node loopNode) {
        Node ptr1 = head;
        Node ptr2 = loopNode;

        // Find the starting point of the loop
        while (ptr1 != ptr2) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // Now find the last node in the loop
        Node last = ptr2;
        while (last.next != ptr2) {
            last = last.next;
        }

        // Break the loop
        last.next = null;
    }
}
