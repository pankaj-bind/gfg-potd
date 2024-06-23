class Solution {
    ArrayList<Integer> bracketNumbers(String str) {
        ArrayList<Integer> result = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int counter = 0;

        for (char ch : str.toCharArray()) {
            if (ch == '(') {
                counter++;
                stack.push(counter);
                result.add(counter);
            } else if (ch == ')') {
                if (!stack.isEmpty()) {
                    result.add(stack.pop());
                }
            }
        }

        return result;
    }
}
