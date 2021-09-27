class Solution {
    public boolean placeWordInCrossword(char[][] board, String word) {
        if (board == null) return false;
        char[][] transpose = new char[board[0].length][board.length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                transpose[j][i] = board[i][j];
            }
        }
        
        return match(board, word) || match(transpose, word);
    }
    
    //row by row
    private boolean match(char[][] board, String word) {
        char[] c = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            int idx = 0;
            while (idx < board[0].length) {
                while (idx < board[0].length && board[i][idx] == '#') idx++;
                int start = idx;
                while (idx < board[0].length && board[i][idx] != '#') idx++;
                int cidx = 0;
                int reverse_end = start;
                int reverse_start = idx;
                if (idx - start == c.length) {
                    while (start < idx && (board[i][start] == ' ' || board[i][start] == c[cidx])) {
                        cidx++;
                        start++;
                    }
                    if (start == idx) return true;
                    cidx = 0;
                    while (reverse_start - 1 >= reverse_end && (board[i][reverse_start - 1] == ' ' || board[i][reverse_start - 1] == c[cidx])) {
                        reverse_start--;
                        cidx++;
                    }
                    if (reverse_start == reverse_end) return true;
                }
                idx++;
            }
            
        }
        return false;
    }
}