class LRUCache {
    
    class Node {
        private Node prev;
        private Node next;
        private int val;
        private int key;
        public Node(int key, int val, Node prev, Node next) {
            this.key = key;
            this.val = val;
            this.prev = prev;
            this.next = next;
        }

        public Node(int key, int val) {
            this(key, val, null, null);
        }
        
        public int getKey() {
            return this.key;
        }
        
        public void setVal(int val) {
            this.val = val;
        }
        
        public int getVal() {
            return this.val;
        }
    }
    
    private Map<Integer, Node> map;
    private int capacity;
    private Node head = new Node(-1, -1);
    private Node tail = null;
    private int size = 0;
    
    public LRUCache(int capacity) {
        this.map = new HashMap<>();
        this.capacity = capacity;
    }
    
    public int get(int key) {
        if (this.map.containsKey(key)) {
            Node temp = this.map.get(key);
            moveNodeToLast(temp);
            return temp.getVal();
        }
        return -1;
    }
    
    public void put(int key, int value) {
        if (tail == null) {
            Node temp = new Node(key, value);
            head.next = temp;
            temp.prev = head;
            tail = temp;
            size++;
            map.put(key, temp);

        } else if (map.containsKey(key)) {
            Node temp = this.map.get(key);
            temp.setVal(value);
            moveNodeToLast(temp);
            
        } else {
            size++;
            Node temp = new Node(key, value);
            tail.next = temp;
            temp.prev = tail;
            tail = tail.next;
            map.put(key, temp);
            if (capacity < size) {
                Node rmv = head.next;
                map.remove(rmv.key);
                
                head.next = head.next.next;
                head.next.prev = head;
            }
        }
    }
    
    private void moveNodeToLast(Node temp) {
        Node prev = temp.prev;
        tail.next = temp;
        temp.prev = tail;
        tail = tail.next;
        prev.next = temp.next;
        temp.next.prev = prev;
        temp.next = null;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */