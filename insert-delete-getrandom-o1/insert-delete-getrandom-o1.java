class RandomizedSet {
    Random r = new Random();
    private List<Integer> l = new ArrayList<>();
    private Map<Integer, Integer> m = new HashMap<>();
    /** Initialize your data structure here. */
    public RandomizedSet() {
        
    }
    
    /** Inserts a value to the set. Returns true if the set did not already contain the specified element. */
    public boolean insert(int val) {
        if (!m.containsKey(val)) {
            l.add(val);
            m.put(val, l.size() - 1);
            return true;
        }
        
        return false;
    }
    
    /** Removes a value from the set. Returns true if the set contained the specified element. */
    public boolean remove(int val) {
        if (m.containsKey(val)) {
            int idx = m.get(val);
            int last = l.size() - 1;
            int temp = l.get(last);
            l.set(idx, temp);
            l.remove(last);
            m.replace(temp, idx);
            m.remove(val);
            return true;
        }
        return false;
        
    }
    
    /** Get a random element from the set. */
    public int getRandom() {
        return l.get(r.nextInt(l.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */