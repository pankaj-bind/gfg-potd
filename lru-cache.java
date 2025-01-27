class LRUCache {
    // Doubly linked list node
    class Node {
        int key, value;
        Node prev, next;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private final int capacity;
    private int size;
    private final Map<Integer, Node> cache;
    private final Node head, tail;

    // Constructor to initialize LRU Cache with a given capacity
    LRUCache(int cap) {
        this.capacity = cap;
        this.size = 0;
        cache = new HashMap<>();
        head = new Node(0, 0);  // dummy head
        tail = new Node(0, 0);  // dummy tail
        head.next = tail;
        tail.prev = head;
    }

    // Function to move a node to the front (most recently used)
    private void moveToFront(Node node) {
        remove(node);
        add(node);
    }

    // Function to remove a node from the linked list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Function to add a node right after the head (most recently used)
    private void add(Node node) {
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
        node.prev = head;
    }

    // Function to return the value corresponding to the key
    public int get(int key) {
        if (!cache.containsKey(key)) {
            return -1;  // key not found
        }
        Node node = cache.get(key);
        moveToFront(node);  // move the accessed node to the front
        return node.value;
    }

    // Function to insert a key-value pair
    public void put(int key, int value) {
        if (cache.containsKey(key)) {
            // If key exists, update the value and move it to the front
            Node node = cache.get(key);
            node.value = value;
            moveToFront(node);
        } else {
            // If key doesn't exist, add a new node
            if (size == capacity) {
                // Evict the least recently used node (the one at the tail)
                Node lru = tail.prev;
                cache.remove(lru.key);
                remove(lru);
                size--;
            }
            // Add the new key-value pair
            Node newNode = new Node(key, value);
            cache.put(key, newNode);
            add(newNode);
            size++;
        }
    }
}
