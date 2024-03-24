class Solution {
    public Stack<Integer> insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x); // If the stack is empty, simply push the element
        } else {
            // Remove the top element and insert x at the bottom recursively
            int top = st.pop();
            insertAtBottom(st, x);
            // Push the top element back after the recursive insertion
            st.push(top);
        }
        return st;
    }
}