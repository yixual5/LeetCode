class StockSpanner {
    Deque<int[]> s;
    public StockSpanner() {
         this.s = new ArrayDeque<>();
    }
    
    public int next(int price) {
        int result = 1;
        while (!s.isEmpty() && s.peek()[0] <= price) {
            result += s.pop()[1];
        }
        s.push(new int[]{price, result});
        return result;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */