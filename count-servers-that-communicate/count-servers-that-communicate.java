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

//one pass
class Solution {
    // two pass
    public int countServers(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int total = 0;
        int ca = 0;
        for (int i = 0; i < row; i++) {
            int count = 0;
            int idx = 0;
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    idx = j;
                    count++;
                    total++;
                }
            }
            if (count == 1) {
                for (int k = 0; k < row; k++) {
                    if (grid[k][idx] == 1) count++;
                    
                }
                if (count == 2) ca++;
            }
        }
        
        return total - ca;
    }
}
