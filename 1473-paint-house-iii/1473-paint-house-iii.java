class Solution {
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        Integer[][][] dp = new Integer[101][21][101];
        int res = dfs(houses, cost, m, n, target, 0, 0, 0, dp);
        return res == 1e8 ? -1 : res;
    }
    
    private int dfs(int[] houses, int[][] cost, int m, int n, int target, int curHouse, int curTarget, int prevColor, Integer[][][] dp) {
        if (curHouse == m || curTarget > target) {
            return curTarget == target ? 0 : (int) 1e8;
        }
        if (dp[curHouse][prevColor][curTarget] != null) return dp[curHouse][prevColor][curTarget];
        if (houses[curHouse] != 0) {
            return dp[curHouse][prevColor][curTarget] = dfs(houses, cost, m, n, target, curHouse + 1, curTarget + (houses[curHouse] == prevColor ? 0 : 1), houses[curHouse], dp);
        }
        int res = (int) 1e8;
        for (int i = 1; i <= n; i++) {
            res = Math.min(res, dfs(houses, cost, m, n, target, curHouse + 1, curTarget  + (i == prevColor ? 0 : 1), i, dp) + cost[curHouse][i - 1]);
        }
        return dp[curHouse][prevColor][curTarget] = res;
    }
} 