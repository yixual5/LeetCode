// 20 mins
class MyHashMap {
    class Node {
        int val;
        int key;
        Node next;
        public Node(int key, int val, Node next) {
            this.key = key;
            this.val = val;
            this.next = next;
        }
    }
    
    private Node[] table;
    /** Initialize your data structure here. */
    public MyHashMap() {
        table = new Node[2069];
    }
    
    /** value will always be non-negative. */
    public void put(int key, int value) {
        int idx = key % 2069;
        if (table[idx] == null) {
            table[idx] = new Node(key, value, null);
            return;
        } 
        Node temp = table[idx];
        while (temp != null) {
            if (temp.key == key) {
                temp.val = value;
                return;
            }
            temp = temp.next;
        }
        
        Node temp1 = new Node(key, value, table[idx]);
        table[idx] = temp1;
        
    }
    
    /** Returns the value to which the specified key is mapped, or -1 if this map contains no mapping for the key */
    public int get(int key) {
        int idx = key % 2069;
        Node temp = table[idx];
        while (temp != null) {
            if (temp.key == key) return temp.val;
            temp = temp.next;
        }
        return - 1;
    }
    
    /** Removes the mapping of the specified value key if this map contains a mapping for the key */
    public void remove(int key) {
        int idx = key % 2069;
        Node temp = table[idx];
        if (temp == null) return;
        if (temp.key == key) {
            table[idx] = temp.next;
            return;
        }
        while (temp.next != null) {
            if (temp.next.key == key) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */
