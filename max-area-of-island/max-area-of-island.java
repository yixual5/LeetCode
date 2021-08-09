// iterative bfs, 20 mins
class Solution {
    
    int[] x = new int[]{1, -1, 0, 0};
    int[] y = new int[]{0, 0, 1, -1};
    int totalRow;
    int totalCol;
    public int maxAreaOfIsland(int[][] grid) {
        if (grid == null || grid.length == 0) return 0;
        int count = 0;
        totalCol = grid[0].length;
        totalRow = grid.length;
        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[0].length; col++) {
                if (grid[row][col] == 1) {
                    count = Math.max(count, bfs(row, col, grid));
                }
            }
        }
        return count;
    }
    
    private int bfs(int row, int col, int[][] grid) {
        int count = 0;
        Queue<Integer> q = new LinkedList<>();
        q.offer(row * totalCol + col);
        grid[row][col] = 0;
        while (!q.isEmpty()) {
            count++;
            int val = q.poll();
            row = val / totalCol;
            col = val % totalCol;
            for (int i = 0; i < 4; i++) {
                int newRow = row + y[i];
                int newCol = col + x[i];
                if (newRow >= 0 && newRow < totalRow && newCol >= 0 && newCol < totalCol && grid[newRow][newCol] == 1) {
                    grid[newRow][newCol] = 0;
                    q.offer(newRow * totalCol + newCol);
                }
            }
        }
        return count;
    }
}
