class Solution {
    int[] memo;
    int[][] stations;
    public int minRefuelStops(int target, int startFuel, int[][] stations) {        
        if (startFuel >= target) return 0;
        if (stations == null || stations.length == 0) return -1;
        int[][] dp = new int[stations.length + 1][stations.length + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = startFuel;
        }
        for (int i = 1; i < dp.length; i++) {
            for (int j = 1; j <= i; j++) {
                dp[i][j] = dp[i - 1][j];
                if (dp[i - 1][j - 1] >= stations[i - 1][0]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + stations[i - 1][1]);
                }
            }
        }
        for (int i = 0; i < dp.length; i++) {
            if (dp[stations.length][i] >= target) return i;
        }
        return -1;
    }
}