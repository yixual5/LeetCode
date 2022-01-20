class Solution {
    int[] x = new int[]{1, 0, 0, -1};
    int[] y = new int[]{0, -1, 1, 0};
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int res = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    res++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }
    
    private void dfs(char[][] grid, int row, int col) {
        grid[row][col] = '2';
        for (int i = 0; i < 4; i++) {
            if (valid(grid, row + x[i], col + y[i])) {
                dfs(grid, row + x[i], col + y[i]);
            }
        }
    }
    
    private boolean valid(char[][] grid, int row, int col) {
        return row >= 0 && row < grid.length && col >=0 && col < grid[0].length && grid[row][col] == '1';
    }
    
    
}