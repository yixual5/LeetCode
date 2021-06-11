class KthLargest {
    PriorityQueue<Integer> heap;
    int k;
    public KthLargest(int k, int[] nums) {
        this.k = k;
        this.heap = new PriorityQueue<>();
        for (int num: nums) {
            heap.add(num);
            if (heap.size() > k) heap.poll();
        }
    }
    
    public int add(int val) {
        if (heap.size() < this.k){
            heap.add(val);
            return heap.peek();
        }
        if (val <= heap.peek()) return heap.peek();
        heap.add(val);
        heap.poll();
        return heap.peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */