class Solution {
    public long multiplyTwoLists(Node first, Node second) {
        long num1 = 0;
        long num2 = 0;
        long mod = 1000000007;

        // Convert first linked list to number
        while (first != null) {
            num1 = (num1 * 10 + first.data) % mod;
            first = first.next;
        }

        // Convert second linked list to number
        while (second != null) {
            num2 = (num2 * 10 + second.data) % mod;
            second = second.next;
        }

        // Return the product modulo 10^9 + 7
        return (num1 * num2) % mod;
    }
}
