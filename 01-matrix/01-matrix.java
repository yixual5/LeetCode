class Solution {
    int[] xdirection = new int[] {1,0,-1,0};
    int[] ydirection = new int[]{0,1,0,-1};
    public int[][] updateMatrix(int[][] mat) {
        int row = mat.length;
        int column = mat[0].length;
        //int[][] visited = new int[row][column];
        Queue<int[]> q = new LinkedList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < column; j++) {
                if (mat[i][j] == 0) {
                    q.offer(new int[]{i,j});
                } else {
                    mat[i][j] = -1;
                    //visited[i][j] = -1;
                }
            }
        }
        int level = 1;
        
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int s = 0; s < sz; s++){
                int[] temp = q.poll();
                int i = temp[0];
                int j = temp[1];
                for (int k = 0; k < 4; k++) {
                    int newi = i + xdirection[k];
                    int newj = j + ydirection[k];
                    if (check(newi, newj, row, column) && mat[newi][newj] == -1) {
                        q.offer(new int[]{newi, newj});
                        //visited[newi][newj] = 0;
                        mat[newi][newj] = level;
                    }
                }
            }
            level++;
            
            
        }
        return mat;
    }
    
    private boolean check(int x, int y, int row, int column) {
        return x < row && y < column && x >= 0 && y >= 0;
    }
}