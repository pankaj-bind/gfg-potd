class Solution {

    public ArrayList<Integer> Ancestors(Node root, int target) {
        ArrayList<Integer> result = new ArrayList<>();
        findAncestors(root, target, result);
        return result;
    }

    private boolean findAncestors(Node root, int target, ArrayList<Integer> result) {
        // Base case
        if (root == null) {
            return false;
        }

        // If target node is found
        if (root.data == target) {
            return true;
        }

        // Recursively check in the left and right subtrees
        if (findAncestors(root.left, target, result) || findAncestors(root.right, target, result)) {
            result.add(root.data);
            return true;
        }

        return false;
    }
}
