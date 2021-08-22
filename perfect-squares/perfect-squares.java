class Solution {
    public int numSquares(int n) {
        int range =(int) Math.sqrt(n);
        int[] dp = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 1; i <= range; i++) {
            for (int j = i * i; j <= n; j++) {
                if (dp[j - i * i] != n + 1) {
                    dp[j] = Math.min(dp[j - i * i] + 1, dp[j]);
                }
            }
        }
        return dp[n] == n + 1 ? -1 : dp[n];
    }
}