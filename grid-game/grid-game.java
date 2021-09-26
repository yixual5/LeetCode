class Solution {
    public long gridGame(int[][] grid) {
        int n = grid[0].length;
        long[] suffixSum = new long[n];
        long[] prefixSum = new long[n];
        suffixSum[n - 1] = grid[0][n - 1];
        prefixSum[0] = grid[1][0];
        for (int i = n - 2; i >= 0; i--) {
            suffixSum[i] = (long)grid[0][i] + suffixSum[i + 1];
        }
        for (int i = 1; i < n; i++) {
            prefixSum[i] = prefixSum[i - 1] + (long)grid[1][i];
        }
        long mi = Long.MAX_VALUE;
        for (int step = 0; step < n; step++) {
            if (step == 0) {
                mi = Math.min(suffixSum[step + 1], mi);
            } else if (step == n - 1) {
                mi = Math.min(prefixSum[step - 1], mi);
            } else {
                mi = Math.min(Math.max(prefixSum[step - 1], suffixSum[step + 1]), mi);
            }
            
        }
        return mi;
    }
}