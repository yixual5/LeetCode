// naive apporach O(nlogn)
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

// two heap, max heap maintain half of smaller value and min heap maintain half of larger value
class MedianFinder {
    Queue<Integer> minheap = new PriorityQueue<>((q1,q2) -> q1 - q2);
    Queue<Integer> maxheap = new PriorityQueue<>((q1, q2) -> q2 - q1);
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        maxheap.offer(num);
        minheap.offer(maxheap.poll());
        if (maxheap.size() < minheap.size()) {
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        return maxheap.size() > minheap.size() ? maxheap.peek() : (double) (maxheap.peek() + minheap.peek()) / 2;
    }
}

// two heap, reduce the offer and poll operation by 2
class MedianFinder {
    Queue<Integer> minheap = new PriorityQueue<>((q1,q2) -> q1 - q2);
    Queue<Integer> maxheap = new PriorityQueue<>((q1, q2) -> q2 - q1);
    /** initialize your data structure here. */
    public MedianFinder() {
        
    }
    
    public void addNum(int num) {
        
        if (!maxheap.isEmpty() && maxheap.peek() < num) {
            minheap.offer(num);
        } else {
            maxheap.offer(num);
        }
        if (maxheap.size() - minheap.size() == 2) {
            minheap.offer(maxheap.poll());
        } else if (maxheap.size() - minheap.size() == -2){
            maxheap.offer(minheap.poll());
        }
    }
    
    public double findMedian() {
        if (maxheap.size() == minheap.size()) return (double) (maxheap.peek() + minheap.peek()) / 2;
        if (maxheap.size() < minheap.size()) return minheap.peek();
        return maxheap.peek();
    }
}


