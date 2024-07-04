class Solution {
    private Map<String, Integer> subtreeMap;
    private List<Node> duplicates;

    public Solution() {
        this.subtreeMap = new HashMap<>();
        this.duplicates = new ArrayList<>();
    }

    public List<Node> printAllDups(Node root) {
        serializeTree(root);
        return duplicates;
    }

    private String serializeTree(Node node) {
        if (node == null) {
            return "#";
        }

        String serialized = node.data + "," + serializeTree(node.left) + "," + serializeTree(node.right);

        subtreeMap.put(serialized, subtreeMap.getOrDefault(serialized, 0) + 1);

        if (subtreeMap.get(serialized) == 2) {
            duplicates.add(node);
        }

        return serialized;
    }
}
