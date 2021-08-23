class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        
        int[] dp = new int[target + 1];
        dp[0] = 1;
        int mod = (int) 1e+9 + 7;
        
        for (int i = 1; i <= d; i++) {
            int[] next = new int[target + 1];
            
            for (int j = 1; j <= target; j++) {
                for (int k = 1; k <= f; k++) {
                    if (j - k < 0) continue;
                    next[j] += dp[j - k];
                    next[j] %= mod;
                }
            }
            dp = next;
        }
        return dp[target];
    }
}

// some optimization
class Solution {
    public int numRollsToTarget(int d, int f, int target) {
        if (d * f < target) return 0;
        int[][] dp = new int[d + 1][target + 1];
        dp[0][0] = 1;
        int mod = (int) 1e+9 + 7;
        
        for (int i = 1; i <= d; i++) {
            
            for (int j = i; j <= target; j++) {
                if(i * f < j){
                    break;
                }
                for (int k = 1; k <= f; k++) {
                    if (j - k < 0) continue;
                    dp[i][j] += dp[i - 1][j - k];
                    dp[i][j] %= mod;
                }
            }
            
        }
        return dp[d][target];
    }
}
