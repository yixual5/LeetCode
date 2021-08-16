class Solution {
    private int[] x = new int[]{0, 0, 1, 1, 1, -1, -1, -1};
    private int[] y = new int[]{1, -1, 1, -1, 0, 0, 1, -1};
    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null ||board[click[0]][click[1]] == 'M' || board[click[0]][click[1]] == 'X') {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        dfs(click[0], click[1], board);
        return board;
    }
    
    private void dfs(int row, int col, char[][] board) {
        
        int count = 0;
        for (int i = 0; i < 8; i++) {
            int nextRow = row + x[i];
            int nextCol = col + y[i];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && (board[nextRow][nextCol] == 'M' || board[nextRow][nextCol] == 'X')) {
                count++;
            }
        }
        if (count > 0) {
            board[row][col] = (char) (count + '0');
            return;
        }
        board[row][col] = 'V';
        for (int i = 0; i < 8; i++) {
            int nextRow = row + x[i];
            int nextCol = col + y[i];
            if (nextRow >= 0 && nextRow < board.length && nextCol >= 0 && nextCol < board[0].length && board[nextRow][nextCol] != 'V' && board[nextRow][nextCol] == 'E') {
                dfs(nextRow, nextCol, board);
            }
        }
        board[row][col] = 'B';
    }
}