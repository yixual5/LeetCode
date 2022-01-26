class TicTacToe {
    private int[] rowCount;
    private int[] colCount;
    private int diag;
    private int anti;
    public TicTacToe(int n) {
        this.rowCount = new int[n];
        this.colCount = new int[n];
        this.diag = 0;
        this.anti = 0;
    }
    
    public int move(int row, int col, int player) {
        int ply = player == 2 ? -1 : player;
        rowCount[row] += ply;
        colCount[col] += ply;
        int n = rowCount.length;
        if (row == col) diag += ply;
        if (row == n - 1 - col) anti += ply;
        if (Math.abs(rowCount[row]) == n || Math.abs(colCount[col]) == n || Math.abs(diag) == n || Math.abs(anti) == n) return player;
        return 0;
    }
}

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */