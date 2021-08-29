class Solution {
    public int maxProfit(int[] prices) {
        int dpi10 = 0, dpi20 = 0, dpi11 = Integer.MIN_VALUE, dpi21 = Integer.MIN_VALUE;
        // i means ith of prices, the first integer is how many transaction
        // the second one is the stock you have after ith operation
        //dp[i][k][0] = max(dp[i - 1][k][0], dp[i - 1][k][1] + price)
        //dp[i][k][1] = max(dp[i - 1][k][1], dp[i - 1][k - 1][0] - price)
        // sold and buy
        for (int price : prices) {
            dpi20 = Math.max(dpi20, dpi21 + price);
            dpi21 = Math.max(dpi21, dpi10 - price);
            dpi10 = Math.max(dpi10, dpi11 + price);
            dpi11 = Math.max(dpi11, - price);
        }
        return dpi20;
    }
}