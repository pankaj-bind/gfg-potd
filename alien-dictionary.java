class Solution {
    public String findOrder(String[] dict, int n, int k) {
        // Create adjacency list
        List<Integer>[] adj = new ArrayList[k];
        for (int i = 0; i < k; i++) {
            adj[i] = new ArrayList<>();
        }

        // Build the graph by comparing adjacent words
        for (int i = 0; i < n - 1; i++) {
            String word1 = dict[i];
            String word2 = dict[i + 1];
            int len = Math.min(word1.length(), word2.length());

            for (int j = 0; j < len; j++) {
                if (word1.charAt(j) != word2.charAt(j)) {
                    adj[word1.charAt(j) - 'a'].add(word2.charAt(j) - 'a');
                    break; // stop at the first different character
                }
            }
        }

        // Perform topological sort using Kahn's algorithm (BFS)
        int[] inDegree = new int[k];
        for (int i = 0; i < k; i++) {
            for (int neighbor : adj[i]) {
                inDegree[neighbor]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < k; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        StringBuilder order = new StringBuilder();
        while (!queue.isEmpty()) {
            int curr = queue.poll();
            order.append((char) (curr + 'a'));

            for (int neighbor : adj[curr]) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        // If order contains all k characters, return it, otherwise return an empty string
        return order.length() == k ? order.toString() : "";
    }
}
