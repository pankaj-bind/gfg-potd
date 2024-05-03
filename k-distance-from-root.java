class Tree
{
     // Recursive function to print nodes at distance k from the root.
     ArrayList<Integer> Kdistance(Node root, int k)
     {
          ArrayList<Integer> result = new ArrayList<>();
          
          // Base case: if the root is null, return empty result
          if (root == null)
              return result;
          
          Queue<Node> queue = new LinkedList<>();
          queue.offer(root);
          int level = 0;
          
          while (!queue.isEmpty()) {
              int size = queue.size();
              // Traverse all nodes at the current level
              for (int i = 0; i < size; i++) {
                  Node curr = queue.poll();
                  // If current level matches k, add node value to result
                  if (level == k) {
                      result.add(curr.data);
                  }
                  // Explore left and right children if they exist
                  if (curr.left != null) {
                      queue.offer(curr.left);
                  }
                  if (curr.right != null) {
                      queue.offer(curr.right);
                  }
              }
              level++; // Move to the next level
              // If we have already found nodes at distance k, break the loop
              if (level > k) {
                  break;
              }
          }
          
          return result;
     }
}