//data-structure design

class LRUCache {
    class DLinkedNode {
        int key;
        int val;
        DLinkedNode prev;
        DLinkedNode next;
    }
    
    private void addFront(DLinkedNode node) {
        DLinkedNode temp = Head.next;
        node.prev = Head;
        node.next = temp;
        temp.prev = node;
        Head.next = node;
    }
    
    private void removeNode(DLinkedNode node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
    
    private void moveToFront(DLinkedNode node) {
        removeNode(node);
        addFront(node);
    }
    
    private int RemoveTailAndGetKey() {
        DLinkedNode temp = Tail.prev;
        removeNode(temp);
        return temp.key;
    }
    
    
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private DLinkedNode Head = new DLinkedNode();
    private DLinkedNode Tail = new DLinkedNode();
    
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.Head.next = this.Tail;
        this.Tail.prev = this.Head;
        
        
    }
    
    public int get(int key) {
        DLinkedNode temp = cache.get(key);
        if (temp == null) return -1;
        moveToFront(temp);
        return temp.val;
    }
    
    public void put(int key, int value) {
        DLinkedNode temp = cache.get(key);
        if (temp == null) {
            temp = new DLinkedNode();
            temp.key = key;
            temp.val = value;
            if (cache.size() == capacity) {
                int rvkey = RemoveTailAndGetKey();
                cache.remove(rvkey);
            }
            cache.put(key, temp);
            addFront(temp);
        } else {
            temp.val = value;
            moveToFront(temp);
        }
        
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
