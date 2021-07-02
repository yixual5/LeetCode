class MedianFinder {
    List<Integer> l = new ArrayList<>();
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        l.add(num);
    }
    
    public double findMedian() {
        Collections.sort(l);
        int mid = l.size() / 2;
        return l.size() % 2 == 0 ? (double)(l.get(mid - 1) + l.get(mid)) / 2 : l.get(mid);
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */