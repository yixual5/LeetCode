class Solution {
    public boolean exist(char[][] board, String word) {
        char[] wd = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == wd[0] && backtracking(board, wd, 0, i, j)) return true;
            }
        }
        return false;
    }
    
    private boolean backtracking(char[][] board, char[] word, int idx, int i, int j) {
        if (idx == word.length) return true;
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word[idx] != board[i][j]) return false;
        char c = board[i][j];
        board[i][j] = '#';
        if (backtracking(board, word, idx + 1, i + 1, j) || backtracking(board, word, idx + 1, i - 1, j) ||
           backtracking(board, word, idx + 1, i, j + 1) || backtracking(board, word, idx + 1, i, j - 1)) return true;
        board[i][j] = c;
        return false;
    }
}