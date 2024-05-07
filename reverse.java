class Tree
{
    public ArrayList<Integer> reverseLevelOrder(Node node) 
    {
        ArrayList<Integer> result = new ArrayList<>();
        if (node == null)
            return result;

        Queue<Node> queue = new LinkedList<>();
        Stack<Node> stack = new Stack<>();

        queue.offer(node);

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            stack.push(current);

            if (current.right != null)
                queue.offer(current.right);

            if (current.left != null)
                queue.offer(current.left);
        }

        while (!stack.isEmpty()) {
            Node current = stack.pop();
            result.add(current.data);
        }

        return result;
    }
}
