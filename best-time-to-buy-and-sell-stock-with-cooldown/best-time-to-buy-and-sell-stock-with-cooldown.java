class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //prev is two day from right now
        //other are exactly same as ii
        int dpi10 = 0, dpi11 = Integer.MIN_VALUE, dpi10prev = 0;
        for (int price : prices) {
            int dpi10Old = dpi10;
            dpi10 = Math.max(dpi10, dpi11 + price);
            dpi11 = Math.max(dpi11, dpi10prev - price);
            dpi10prev = dpi10Old;
        }
        return dpi10;
    }
}