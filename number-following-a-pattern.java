class Solution{
    static String printMinNumberForPattern(String S){
        // code here
        int n = S.length();
        int[] result = new int[n + 1];
        int current_max = 0;
        int next_element = 1;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i <= n; i++) {
            stack.push(next_element++);
            if (i == n || S.charAt(i) == 'I') {
                while (!stack.isEmpty()) {
                    result[current_max++] = stack.pop();
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n + 1; i++) {
            sb.append(result[i]);
        }

        return sb.toString();
    }
}