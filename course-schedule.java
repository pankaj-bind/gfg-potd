class Solution {
    static int[] findOrder(int n, int m, ArrayList<ArrayList<Integer>> prerequisites) {
        ArrayList<Integer> result = new ArrayList<>();
        int[] inDegree = new int[n];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (ArrayList<Integer> pre : prerequisites) {
            int u = pre.get(0);
            int v = pre.get(1);
            graph.get(v).add(u);
            inDegree[u]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (inDegree[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            int node = queue.poll();
            result.add(node);

            for (int neighbor : graph.get(node)) {
                inDegree[neighbor]--;
                if (inDegree[neighbor] == 0) {
                    queue.add(neighbor);
                }
            }
        }

        if (result.size() != n) {
            // Not all tasks can be finished
            return new int[0];
        }

        int[] resArray = new int[n];
        for (int i = 0; i < n; i++) {
            resArray[i] = result.get(i);
        }

        return resArray;
    }
}