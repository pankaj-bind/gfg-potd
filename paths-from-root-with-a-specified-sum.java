class Solution {
    public static ArrayList<ArrayList<Integer>> printPaths(Node root, int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        ArrayList<Integer> currentPath = new ArrayList<>();
        dfs(root, sum, currentPath, result);
        return result;
    }

    private static void dfs(Node node, int remainingSum, ArrayList<Integer> currentPath,
                             ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }

        currentPath.add(node.data);

        // Check if the current path equals the given sum
        if (remainingSum == node.data) {
            result.add(new ArrayList<>(currentPath));
        }

        // Recursively search the left and right subtrees
        dfs(node.left, remainingSum - node.data, currentPath, result);
        dfs(node.right, remainingSum - node.data, currentPath, result);

        // Backtrack by removing the last element to explore other paths
        currentPath.remove(currentPath.size() - 1);
    }
}