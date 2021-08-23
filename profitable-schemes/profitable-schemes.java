//2-d 01 背包
class Solution {
    public int profitableSchemes(int n, int minProfit, int[] group, int[] profit) {
        
        int[][] dp = new int[n + 1][minProfit + 1];
        for (int i = 0; i < n + 1; i++) dp[i][0] = 1;
        int mod = (int) 1e9+7;
        for (int i = 0; i < group.length; i++) {
            for (int j = n; j >= group[i]; j--) {
                for (int k = minProfit + profit[i]; k >= profit[i]; k--) {
                    int idx = Math.min(k, minProfit);
                    dp[j][idx] += dp[j - group[i]][k - profit[i]];
                    dp[j][idx] %= mod;
                }
            }
        }
        return dp[n][minProfit];
    }
}
