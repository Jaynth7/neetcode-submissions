class Node{
    int val;
    int key;
    Node prev;
    Node next;
    public Node(int key , int val){
        this.key = key;
        this.val = val;
        this.prev = null;
        this.next = null;
    }
}

class LRUCache {
    //Capacity of the Cache
    private int cap;
    //HashMap to store the values
    private HashMap<Integer , Node> cache;

    // Dummy nodes marking the boundaries of the list
    // left.next is the LRU node and right.prev is the MRU node
    private Node right;
    private Node left;

    public LRUCache(int capacity) {
        //Have to just create the cache and initialise the pointers

        this.cap = capacity;
        this.cache = new HashMap<>();
        this.right = new Node(0 , 0);
        this.left = new Node(0 , 0);
        this.right.prev = this.left;
        this.left.next = this.right;
    }

    //Creating two methods that are supportive

    // Inserts the node immediately before right,
    // making it the most recently used node
    private void insert(Node node){
        Node prev = this.right.prev;
        prev.next = node;
        node.prev = prev;
        node.next = this.right;
        this.right.prev = node;
    }

    private void remove(Node node){
        Node prev = node.prev;
        Node nxt = node.next;
        prev.next = nxt;
        nxt.prev = prev;
    }
    
    public int get(int key) {
        if(cache.containsKey(key)){
            // Fetch the node associated with the key
            Node node = cache.get(key);
            // The accessed node will no longer the previous MRU,
            // so remove it from its current position
            remove(node);
            //By inserting it again , it will be at the rightmost position in the cache which signifies MRU
            insert(node);
            return node.val;

        }

        return -1;
    }
    
    public void put(int key, int value) {
        if (cache.containsKey(key)){
            remove(cache.get(key));
        }

        Node newNode = new Node(key, value);

        // HashMap: provides O(1) access to a node using its key
        // Doubly Linked List: maintains the LRU -> MRU order in O(1)
        cache.put(key , newNode);
        insert(newNode);

        if(cache.size() > cap){
            Node lru = this.left.next;
            remove(lru);
            cache.remove(lru.key);
        }
    }
}
