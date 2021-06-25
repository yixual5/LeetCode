class MinStack {
    Stack<Integer> s;
    Queue<Integer> q;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        q = new PriorityQueue<>((v1, v2) -> v1.compareTo(v2));
    }
    
    public void push(int val) {
        s.push(val);
        q.offer(val);
        
    }
    
    public void pop() {
        
        q.remove(s.pop());
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return q.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */