class Solution {
    public int maxProfit(int[] prices) {
        int res = 0;
        int left = 0;
        int right = 0;
        while (right < prices.length) {
            while (left < right && prices[left] > prices[right]) left++;
            res = Math.max(res, prices[right++] - prices[left]);
        }
        return res;
    }
}