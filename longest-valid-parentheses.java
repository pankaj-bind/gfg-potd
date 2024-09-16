class Solution{
    static int maxLength(String S){
        // Stack to store indices
        Stack<Integer> stack = new Stack<>();
        // Initialize the stack with a base value to handle edge cases
        stack.push(-1);
        int maxLength = 0;
        
        for (int i = 0; i < S.length(); i++) {
            // If we encounter an opening bracket, push its index onto the stack
            if (S.charAt(i) == '(') {
                stack.push(i);
            } else {
                // If we encounter a closing bracket, pop the top of the stack
                stack.pop();
                
                // If stack is not empty, calculate the length of the valid substring
                if (!stack.isEmpty()) {
                    maxLength = Math.max(maxLength, i - stack.peek());
                } else {
                    // If stack becomes empty, push the current index as a base for the next valid substring
                    stack.push(i);
                }
            }
        }
        
        return maxLength;
    }
}
