class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int min = prices[0];
        int max = prices[0];
        int profit = 0;
        int idx = 0;
        while (idx < prices.length - 1) {
            while (idx < prices.length - 1 && prices[idx] >= prices[idx + 1]) idx++;
            min = prices[idx];
            while (idx < prices.length - 1 && prices[idx] <= prices[idx + 1]) idx++;
            profit += prices[idx] - min;
        }
        return profit;
    }
}

// as long as increase, we can keep add
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) profit += prices[i] - prices[i - 1];
        }
        return profit;
    }
}
