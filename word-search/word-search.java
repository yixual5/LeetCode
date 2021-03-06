// backtracking 0(N * 3^L)
class Solution {
    char[] wd;
    char[][] board;
    private int[] x = new int[]{1, 0, 0, -1};
    private int[] y = new int[]{0, 1, -1, 0};
    public boolean exist(char[][] board, String word) {
        if (word == null || word.length() == 0) return true;
        this.board = board;
        this.wd = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if(dfs(0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int idx, int i, int j) {
        if (idx == wd.length) return true;
        if (j < 0 || j >= board[0].length || i < 0 || i >= board.length || board[i][j] != wd[idx]) {
            return false;
        }   
        board[i][j] = '#';
        
        for (int k = 0; k < 4; k++) {
            int col = j + x[k];
            int row = i + y[k];
            
            if(dfs(idx + 1, row, col)) return true;
            
        }
        board[i][j] = wd[idx];
        return false;
        
    }
}
