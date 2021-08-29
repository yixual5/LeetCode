class Solution {
    public int maxProfit(int k, int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        //best time ii
        if (k >= prices.length / 2) {
            int profit = 0;
            for (int i = 1; i < prices.length; i++) {
                if (prices[i] >= prices[i - 1]) {
                    profit += prices[i] - prices[i - 1];
                }
            }
            return profit;
        }
        int[] dpi10 = new int[k + 1];
        int[] dpi11 = new int[k + 1];
        Arrays.fill(dpi11, Integer.MIN_VALUE);
        for (int price : prices) {
            for (int i = k; i > 0; i--) {
                dpi10[i] = Math.max(dpi10[i], dpi11[i] + price);
                dpi11[i] = Math.max(dpi11[i], dpi10[i - 1] - price);
            }
        }
        return dpi10[k];
        
    }
}