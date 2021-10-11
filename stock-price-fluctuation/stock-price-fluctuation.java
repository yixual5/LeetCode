class StockPrice {
    int ts;
    TreeMap<Integer, Integer> priceTocount;
    Map<Integer, Integer> tsToprice; //timestamp and price
    public StockPrice() {
        priceTocount = new TreeMap<>();
        tsToprice = new HashMap<>();
        ts = -1;
    }
    
    public void update(int timestamp, int price) {
        if (timestamp > ts) ts = timestamp;
        int oldPrice = tsToprice.getOrDefault(timestamp, 0);
        tsToprice.put(timestamp, price);
        
        if (oldPrice != 0) {
            priceTocount.put(oldPrice, priceTocount.get(oldPrice) - 1);
            if (priceTocount.get(oldPrice) == 0) priceTocount.remove(oldPrice);
        }
        priceTocount.put(price, priceTocount.getOrDefault(price, 0) + 1);
        
        
    }
    
    public int current() {
        return tsToprice.get(ts);
    }
    
    public int maximum() {
        return priceTocount.lastKey();
    }
    
    public int minimum() {
        return priceTocount.firstKey();
    }
}

/**
 * Your StockPrice object will be instantiated and called as such:
 * StockPrice obj = new StockPrice();
 * obj.update(timestamp,price);
 * int param_2 = obj.current();
 * int param_3 = obj.maximum();
 * int param_4 = obj.minimum();
 */