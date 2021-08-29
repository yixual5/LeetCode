class Solution {
    public int maxProfit(int[] prices, int fee) {
        if (prices == null || prices.length == 0) return 0;
        
        //prev is two day from right now
        //other are exactly same as ii
        int dpi10 = 0, dpi11 = Integer.MIN_VALUE;
        for (int price : prices) {
            int dpi10old = dpi10;
            dpi10 = Math.max(dpi10, dpi11 + price);
            dpi11 = Math.max(dpi11, dpi10old - price - fee);
        }
        return dpi10;
    }
}