class Solution {
    // Function to find the vertical width of a Binary Tree.
    public int verticalWidth(Node root) {
        if (root == null) return 0;

        // Map to store the horizontal distance of nodes
        Map<Node, Integer> hdMap = new HashMap<>();
        // Queue to store nodes for level-order traversal
        Queue<Node> queue = new LinkedList<>();

        // Initialize the root's horizontal distance as 0
        hdMap.put(root, 0);
        queue.add(root);

        int minHd = 0;
        int maxHd = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int hd = hdMap.get(node);

            // Update min and max horizontal distances
            minHd = Math.min(minHd, hd);
            maxHd = Math.max(maxHd, hd);

            // If the left child exists, set its horizontal distance
            if (node.left != null) {
                hdMap.put(node.left, hd - 1);
                queue.add(node.left);
            }

            // If the right child exists, set its horizontal distance
            if (node.right != null) {
                hdMap.put(node.right, hd + 1);
                queue.add(node.right);
            }
        }

        // The vertical width is the number of unique horizontal distances
        return maxHd - minHd + 1;
    }
}
