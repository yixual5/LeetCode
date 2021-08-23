class Solution {
    public int change(int amount, int[] coins) {
        if (amount == 0) return 1;
        if (coins == null || coins.length == 0) return 0;
        int[] dp = new int[amount + 1];
        dp[amount] = 1;
        for (int i = 0; i < coins.length; i++) {
            for (int j = amount; j >= coins[i]; j--) {
                if (dp[j] != 0) dp[j - coins[i]] += dp[j];
            }
        }
        return dp[0];
    }
}