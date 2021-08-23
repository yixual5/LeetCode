// 2d 0-1 knapsack
class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i < strs.length; i++) {
            int ones = 0;
            int zeros = 0;
            for (char c : strs[i].toCharArray()) {
                if (c == '1') ones++;
                else zeros++;
            }
            for (int zero = m; zero >= zeros; zero--) {
                for (int one = n; one >= ones; one--) {
                    dp[zero][one] = Math.max(dp[zero - zeros][one - ones] + 1, dp[zero][one]);
                }
            }
        }
        return dp[m][n];
        
    }
}
