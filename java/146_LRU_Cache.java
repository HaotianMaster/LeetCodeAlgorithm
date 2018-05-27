class LRUCache {
    private class DListNode {
        int key;
        int val;
        DListNode prev;
        DListNode next;
        DListNode(int x, int y) { key = x; val = y;}
    }
    
    private int capacity;
    private int count;
    private DListNode head;
    private DListNode tail;
    private Map<Integer, DListNode> cache;
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.count = 0;
        this.cache = new HashMap<>();
        //Use dummy head and dummy tail to deal with boundary condition
        this.head = new DListNode(-1, -1);
        this.tail = new DListNode(-2, -2);
        head.next = tail;
        head.prev = null;
        tail.next = null;
        tail.prev = head;
    }
    
    public int get(int key) {
        DListNode curr = cache.get(key);
        if (curr == null) {
            return -1;
        }
        else {
            moveToHead(curr);
            return curr.val;
        }
    }
    
    public void put(int key, int value) {
        DListNode curr = cache.get(key);
        if (curr == null) {
            curr = new DListNode(key, value);
            cache.put(key, curr);
            addNode(curr);
            count++;
            if (count > capacity) {
                cache.remove(tail.prev.key);
                tail.prev.prev.next = tail;
                tail.prev = tail.prev.prev;
                count--;
            }
        }
        else {
            moveToHead(curr);
            curr.val = value;
        }
        
        
    }
    
    private void moveToHead(DListNode node) {
        removeNode(node);
        addNode(node);
    }
    
    private void removeNode(DListNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addNode(DListNode node) {
        head.next.prev = node;
        node.next = head.next;
        node.prev = head;
        head.next = node;
    }
}