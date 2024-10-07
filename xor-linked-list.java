class Solution {
    static Node insert(Node head, int data) {
        // Code Here.
        Node temp = new Node(data);
        temp.npx = head;
        head = temp;
        return head;
    }

    // function to print the linked list
    static ArrayList<Integer> getList(Node head) {
        // Code Here.
        ArrayList<Integer> ans = new ArrayList<>();
        Node temp = head;
        while (temp != null) {
            ans.add(temp.data);
            temp = temp.npx;
        }
        return ans;
    }
}
