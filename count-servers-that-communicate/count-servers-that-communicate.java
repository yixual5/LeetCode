class Solution {
    // two pass
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int[] colcount = new int[col];
        int[] rowcount = new int[row];
        int total = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    total++;
                    colcount[j]++;
                    rowcount[i]++;
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1 && colcount[j] == 1 && rowcount[i] == 1) {
                    total--;
                }
            }
        }
        return total;
    }
}