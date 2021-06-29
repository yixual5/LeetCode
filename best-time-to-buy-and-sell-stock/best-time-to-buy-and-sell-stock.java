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

// avoid duplicate computation
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minprice > prices[i]) {
                minprice = prices[i];
            } else {
                maxprofit = Math.max(maxprofit, prices[i] - minprice);
            }
            
        }
        return maxprofit;
    }
}

//Note also can be converted to the maximum subarray problem LC.53. As long as you gain profit, you can hold the stock.
