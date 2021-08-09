// 40 mins, hard to understand boundary of binary search
class TimeMap {
    class valuepair {
        String val;
        int timestamp;
        
        public valuepair(String val, int timestamp) {
            this.val = val;
            this.timestamp = timestamp;
        }
    }
    
    Map<String, List<valuepair>> mp;
    /** Initialize your data structure here. */
    public TimeMap() {
        this.mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        this.mp.computeIfAbsent(key, k -> new ArrayList<>()).add(new valuepair(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (this.mp.containsKey(key)) {
            List<valuepair> l = this.mp.get(key);
            int left = 0;
            int right = l.size() - 1;
            if (l.get(right).timestamp <= timestamp) return l.get(right).val;
            if (l.get(left).timestamp > timestamp) return "";
            while (left <= right) {
                int mid = left + (right - left) / 2;
                if (l.get(mid).timestamp == timestamp) {
                    return l.get(mid).val;
                } else if (l.get(mid).timestamp > timestamp){
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
            return l.get(left - 1).val;
        } else {
            return "";
        }
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */
