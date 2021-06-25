class LFUCache {
    class DLinkedNode {
        int val;
        int key;
        int freq = 1;
        DLinkedNode prev;
        DLinkedNode next;
        
    }
    
    class DoubleLinkedList {
        DLinkedNode Head;
        DLinkedNode Tail;
        public DoubleLinkedList() {
            this.Head = new DLinkedNode();
            this.Tail = new DLinkedNode();
            this.Head.next = this.Tail;
            this.Tail.prev = this.Head;
        }
        
        public void addFront(DLinkedNode node) {
        DLinkedNode temp = Head.next;
        Head.next = node;
        node.prev = Head;
        node.next = temp;
        temp.prev = node;
        }

        public void remove(DLinkedNode node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }

        public void moveToRightPosi(DLinkedNode node) {
            remove(node);
            addFront(node);
        }

        public int removeAndGet() {
            DLinkedNode temp = Tail.prev;
            remove(temp);
            return temp.key;
        }
        
        public boolean isEmpty() {
            if (Head.next == Tail && Tail.prev == Head) return true;
            return false;
        } 

        
    }
    
        
    private Map<Integer, DLinkedNode> cache = new HashMap<>();
    private int capacity;
    private Map<Integer, DoubleLinkedList> freqCount = new HashMap<>();
    private int minfreq;
    
    public LFUCache(int capacity) {
        this.capacity = capacity;
        this.minfreq = 1;
    }
    
    public int get(int key) {
        DLinkedNode temp = cache.get(key);
        if (temp == null) return -1;
        DoubleLinkedList dl = freqCount.get(temp.freq);
        dl.remove(temp);
        if (dl.isEmpty() && minfreq == temp.freq) minfreq++;
        freqCount.computeIfAbsent(++temp.freq, k -> new DoubleLinkedList()).addFront(temp);
        
        return temp.val;
    }
    
    public void put(int key, int value) {
        if (capacity == 0) return;
        DLinkedNode temp = cache.get(key);
        if (temp != null) {
            temp.val = value;
            DoubleLinkedList dl = freqCount.get(temp.freq);
            dl.remove(temp);
            if (dl.isEmpty() && minfreq == temp.freq) minfreq++;
            freqCount.computeIfAbsent(++temp.freq, k -> new DoubleLinkedList()).addFront(temp);
        } else {
            
            if (cache.size() == capacity) {
                
                int k = freqCount.get(minfreq).removeAndGet();
                
                cache.remove(k);
                
            }
            temp = new DLinkedNode();
            temp.val = value;
            temp.key = key;
            cache.put(key, temp);
            freqCount.computeIfAbsent(temp.freq, k -> new DoubleLinkedList()).addFront(temp);
            minfreq = 1;
        }
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */
