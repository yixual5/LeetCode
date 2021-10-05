class Solution {
    int[][] cols;
    int[][] rows;
    int[][] box;
    public boolean isValidSudoku(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        cols = new int[m][n + 1];
        rows = new int[m][n + 1];
        box = new int[m][n + 1];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                char c = board[i][j];
                if (c == '.' || check(i, j, c - '0')) continue;
                return false;
            }
        }
        return true;
    }
    
    private boolean check(int row, int col, int val) {
        int box_idx = col / 3 + (row / 3) * 3;

        cols[col][val]++;
        rows[row][val]++;
        box[box_idx][val]++;
        if (cols[col][val] > 1 || rows[row][val] > 1 || box[box_idx][val] > 1) return false;
        return true;
    }
}