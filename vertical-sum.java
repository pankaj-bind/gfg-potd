class Solution {
    public ArrayList<Integer> verticalSum(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store vertical sums
        TreeMap<Integer, Integer> verticalSumMap = new TreeMap<>();

        // Perform depth-first traversal
        verticalSumUtil(root, 0, verticalSumMap);

        // Add sums to the result list
        for (int sum : verticalSumMap.values()) {
            result.add(sum);
        }

        return result;
    }

    private void verticalSumUtil(Node node, int horizontalDistance, TreeMap<Integer, Integer> verticalSumMap) {
        if (node == null) return;

        // Update the sum for current vertical line
        verticalSumMap.put(horizontalDistance, verticalSumMap.getOrDefault(horizontalDistance, 0) + node.data);

        // Traverse left subtree with horizontal distance reduced by 1
        verticalSumUtil(node.left, horizontalDistance - 1, verticalSumMap);

        // Traverse right subtree with horizontal distance increased by 1
        verticalSumUtil(node.right, horizontalDistance + 1, verticalSumMap);
    }
}
