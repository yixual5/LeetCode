// two-stack
class MinStack {
    Stack<Integer> s;
    Stack<Integer> s2;
    int min;
    /** initialize your data structure here. */
    public MinStack() {
        s = new Stack<>();
        s2 = new Stack<>();
    }
    
    public void push(int val) {
        if (s2.isEmpty() || val <= s2.peek()) {
            s2.push(val);
        } else {
            s2.push(s2.peek());
        }
        s.push(val);
        
    }
    
    public void pop() {
        s2.pop();
        s.pop();
        
    }
    
    public int top() {
        return s.peek();
    }
    
    public int getMin() {
        return s2.peek();
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
