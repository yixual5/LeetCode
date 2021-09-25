class Solution {
    int[] col;
    int[] diag;
    int[] anti_diag;
    public List<List<String>> solveNQueens(int n) {
        char[][] board = new char[n][n];
        col = new int[n];
        diag = new int[2*n];
        anti_diag = new int[2*n];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<>();
        backtracking(board, 0, result);
        return result;
    }
    
    private void backtracking(char[][] board, int row, List<List<String>> result) {
        if (row == board.length) {
            List<String> temp = new ArrayList<>();
            for (char[] board_row : board) {
                temp.add(new String(board_row));
            }
            result.add(temp);
            return;
        }
        for (int i = 0; i < board[0].length; i++) {
            if (col[i] == 1 || diag[row - i + board.length] == 1 || anti_diag[row + i] == 1 || board[row][i] == 'Q') {
                continue;
            }
            col[i] = 1; 
            diag[row - i + board.length] = 1;
            anti_diag[row + i] = 1;
            board[row][i] = 'Q';
            backtracking(board, row + 1, result);
            col[i] = 0; 
            diag[row - i + board.length] = 0;
            anti_diag[row + i] = 0;
            board[row][i] = '.';
        }
    }
}