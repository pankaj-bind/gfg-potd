class Solution {
    public static Node findFirstNode(Node head) {
        if (head == null || head.next == null) return null; // No loop possible

        Node slow = head, fast = head;

        // Step 1: Detect loop using Floyd's Cycle Detection Algorithm
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                // Loop detected
                break;
            }
        }

        // If no loop was found, return null
        if (fast == null || fast.next == null) {
            return null;
        }

        // Step 2: Find the first node of the loop
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        // The node where slow and fast meet is the first node of the loop
        return slow;
    }
}
