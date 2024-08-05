class Solution {
    public ArrayList<Integer> bottomView(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        // TreeMap to store the last node at each horizontal distance
        TreeMap<Integer, Integer> map = new TreeMap<>();
        Queue<Node> queue = new LinkedList<>();

        // Initialize the queue with the root node and horizontal distance 0
        root.hd = 0;
        queue.add(root);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();
            int hd = temp.hd;

            // Overwrite the data at the current horizontal distance in the map
            map.put(hd, temp.data);

            // If there's a left child, add it to the queue with hd - 1
            if (temp.left != null) {
                temp.left.hd = hd - 1;
                queue.add(temp.left);
            }

            // If there's a right child, add it to the queue with hd + 1
            if (temp.right != null) {
                temp.right.hd = hd + 1;
                queue.add(temp.right);
            }
        }

        // Add the bottom view nodes to the result list
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            result.add(entry.getValue());
        }

        return result;
    }
}
