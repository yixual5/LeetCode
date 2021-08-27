//factor 2 and 3 works best, math
class Solution {
    public int integerBreak(int n) {
        if (n == 2) return 1;
        if (n == 3) return 2;
        if (n % 3 == 0) return (int) Math.pow(3, n / 3);
        if (n % 3 == 2) return 2 * (int) Math.pow(3, (n - 2) / 3);
        return 4 * (int) Math.pow(3, (n - 4) / 3);
    }
}

//dp
class Solution {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
            }
        }
        return dp[n];
    }
}
