class Solution {
    // Function to find the length of a loop in the linked list.
    public int countNodesinLoop(Node head) {
        if (head == null || head.next == null) {
            return 0; // No loop if list is empty or has only one node.
        }

        Node slow = head, fast = head;

        // Step 1: Detect loop using Floyd's Cycle Detection Algorithm.
        while (fast != null && fast.next != null) {
            slow = slow.next;          // Move slow pointer by 1 step.
            fast = fast.next.next;     // Move fast pointer by 2 steps.

            if (slow == fast) {        // Loop detected
                return countLoopLength(slow);
            }
        }

        return 0; // No loop found
    }

    // Function to count the number of nodes in the loop.
    private int countLoopLength(Node nodeInLoop) {
        Node temp = nodeInLoop;
        int count = 1;

        // Move around the loop until we reach the same node again.
        while (temp.next != nodeInLoop) {
            count++;
            temp = temp.next;
        }

        return count;
    }
}
