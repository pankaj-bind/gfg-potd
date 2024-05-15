class Solution {
    static List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> graph = new HashMap<>();

        // Step 1: Build the graph and emailToName map
        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                emailToName.put(email, name);
                graph.putIfAbsent(email, new HashSet<>());
                if (i == 1) continue;
                String prevEmail = account.get(i - 1);
                graph.get(prevEmail).add(email);
                graph.get(email).add(prevEmail);
            }
        }

        // Step 2: Traverse the graph to merge accounts
        Set<String> visited = new HashSet<>();
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (String email : graph.keySet()) {
            if (!visited.contains(email)) {
                List<String> account = new ArrayList<>();
                dfs(graph, visited, email, account);
                Collections.sort(account);
                account.add(0, emailToName.get(email));
                mergedAccounts.add(account);
            }
        }
        return mergedAccounts;
    }

    private static void dfs(Map<String, Set<String>> graph, Set<String> visited, String email, List<String> account) {
        visited.add(email);
        account.add(email);
        for (String neighbor : graph.get(email)) {
            if (!visited.contains(neighbor)) {
                dfs(graph, visited, neighbor, account);
            }
        }
    }
}