class Tree {
    // Function to serialize a tree and return a list containing nodes of the tree.
    public ArrayList<Integer> serialize(Node root) {
        ArrayList<Integer> result = new ArrayList<>();
        if (root == null) return result;

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            if (current != null) {
                result.add(current.data);
                queue.offer(current.left);
                queue.offer(current.right);
            } else {
                result.add(null); // Adding null for empty nodes
            }
        }

        return result;
    }

    // Function to deserialize a list and construct the tree.
    public Node deSerialize(ArrayList<Integer> A) {
        if (A == null || A.size() == 0 || A.get(0) == null) return null;

        Queue<Node> queue = new LinkedList<>();
        Node root = new Node(A.get(0));
        queue.offer(root);

        for (int i = 1; i < A.size(); ) {
            Node parent = queue.poll();

            Integer leftVal = A.get(i++);
            Integer rightVal = (i < A.size()) ? A.get(i++) : null;

            if (leftVal != null) {
                parent.left = new Node(leftVal);
                queue.offer(parent.left);
            }

            if (rightVal != null) {
                parent.right = new Node(rightVal);
                queue.offer(parent.right);
            }
        }

        return root;
    }
}
