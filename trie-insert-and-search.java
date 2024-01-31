static void insert(TrieNode root, String key) {
    TrieNode current = root;
    int n = key.length();
    for (int i = 0; i < n; i++) {
        int index = key.charAt(i) - 'a';
        if (current.children[index] == null) {
            current.children[index] = new TrieNode();
        }
        current = current.children[index];
    }
    current.isEndOfWord = true;
}

// Function to use TRIE data structure and search the given string.
static boolean search(TrieNode root, String key) {
    TrieNode current = root;
    int n = key.length();
    for (int i = 0; i < n; i++) {
        int index = key.charAt(i) - 'a';
        if (current.children[index] == null) {
            return false;
        }
        current = current.children[index];
    }
    return current != null && current.isEndOfWord;
}