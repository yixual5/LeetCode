class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            minprice = Math.min(minprice, prices[i]);
            maxprofit = Math.max(maxprofit, prices[i] - minprice);
        }
        return maxprofit;
    }
}