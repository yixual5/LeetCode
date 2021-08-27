//if factor is greater than or equal to 4, we can break it down to 2 and 3 and increase the amount, so we only consider 3 and 2
//3 is better than 2 : 3 * 3 > 2 * 2 * 2
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
