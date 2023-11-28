class Solution {
    int sumOfDependencies(ArrayList<ArrayList<Integer>> adj, int V) {
        int sum = 0;

        // Iterate through each node
        for (int i = 0; i < V; i++) {
            // Count the number of nodes that the current node depends on
            int dependencies = adj.get(i).size();
            sum += dependencies;
        }

        return sum;
    }
}