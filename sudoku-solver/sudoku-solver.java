// 50 mins
class Solution {
    int n = 3;
    int N = 9;
    int[][] rows = new int[N][N+1];
    int[][] cols = new int[N][N+1];
    int[][] box = new int[N][N+1];
    boolean finished = false;
    char[][] board;
    
    private void place(int num, int row, int col) {
        rows[row][num]++;
        cols[col][num]++;
        // 0 1 2
        // 3 4 5
        // 6 7 8
        int box_idx = col / 3 + (row / 3) * 3;
        box[box_idx][num]++;
        board[row][col] = (char) (num + '0');
    }
    
    private void remove(int num, int row, int col) {
        rows[row][num]--;
        cols[col][num]--;
        int box_idx = col / 3 + (row / 3) * 3;
        box[box_idx][num]--;
        board[row][col] = '.';
    }
    
    private void backtracking(int row, int col) {
        if (row == N) {
            finished = true;
            return;
        }
        if (board[row][col] != '.') {
            if (col == N - 1) {
                backtracking(row + 1, 0);
            } else {
                backtracking(row, col + 1);
            }
        } else {
            for (int i = 1; i < 10; i++) {
                int box_idx = col / 3 + (row / 3) * 3;
                if (rows[row][i] + cols[col][i] + box[box_idx][i] == 0) {
                    place(i, row, col);
                    if (col == N - 1) {
                        backtracking(row + 1, 0);
                    } else {
                        backtracking(row, col + 1);
                    }
                    if (!finished) {
                        remove(i, row, col);
                    }
                }
            }
        }

    }
    
    public void solveSudoku(char[][] board) {
        this.board = board;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] != '.') {
                    place(board[i][j] - '0', i, j);
                }
            }
        }
        backtracking(0, 0);
        
    }
}
