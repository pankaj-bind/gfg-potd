class Solution
{
    // Function to check if brackets are balanced or not.
    static boolean ispar(String x)
    {
        // Create a stack to keep track of opening brackets
        Stack<Character> stack = new Stack<>();

        // Iterate over each character in the string
        for (char ch : x.toCharArray()) {
            // If it's an opening bracket, push it onto the stack
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } 
            // If it's a closing bracket
            else if (ch == '}' || ch == ')' || ch == ']') {
                // Check if the stack is empty (which means there's no matching opening bracket)
                if (stack.isEmpty()) {
                    return false;
                }
                // Get the top element from the stack
                char top = stack.pop();
                // Check if the top element matches the current closing bracket
                if ((ch == '}' && top != '{') ||
                    (ch == ')' && top != '(') ||
                    (ch == ']' && top != '[')) {
                    return false; // Mismatched brackets
                }
            }
        }
        // If the stack is empty at the end, all brackets were matched
        return stack.isEmpty();
    }
}
