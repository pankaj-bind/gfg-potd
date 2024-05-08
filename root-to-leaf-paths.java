class Solution {
    public static ArrayList<ArrayList<Integer>> Paths(Node root) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        ArrayList<Integer> path = new ArrayList<>();
        dfs(root, path, result);
        return result;
    }

    private static void dfs(Node node, ArrayList<Integer> path, ArrayList<ArrayList<Integer>> result) {
        if (node == null) {
            return;
        }
        path.add(node.data); // Add current node to the current path
        if (node.left == null && node.right == null) { // Leaf node reached
            result.add(new ArrayList<>(path)); // Add the current path to the result
        } else {
            dfs(node.left, path, result); // Recursive call for left subtree
            dfs(node.right, path, result); // Recursive call for right subtree
        }
        path.remove(path.size() - 1); // Backtrack: Remove the current node from the path
    }
}