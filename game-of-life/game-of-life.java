class Solution {
    public void gameOfLife(int[][] board) {
        if (board == null || board.length == 0) return;
        int[] x = {0, 0, 1, 1, 1, -1, -1, -1};
        int[] y = {1, -1, 1, 0, -1, 1, 0, -1};
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                int count = 0;
                for (int i = 0; i < 8; i++) {
                    int newRow = row + y[i];
                    int newCol = col + x[i];
                    if (newRow >= 0 && newRow < board.length && newCol >=0 && newCol < board[0].length && Math.abs(board[newRow][newCol]) == 1) {
                        count++;
                    }
                }
                if ((count < 2 || count > 3) && board[row][col] == 1) {
                    board[row][col] = -1;
                } else if (count == 3 && board[row][col] == 0) {
                    board[row][col] = 2;
                }
            }
        }
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (board[row][col] == 2) board[row][col] = 1;
                else if (board[row][col] == -1) board[row][col] = 0;
            }
        }
    }
}