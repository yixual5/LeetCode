class Solution {
    
    private void dfs(int[][] isConnected, int i) {
        for (int j = 0; j < isConnected[0].length; j++) {
            if (isConnected[i][j] == 1) {
                isConnected[i][j] = 2;
                dfs(isConnected, j);
            }
        }
    }
    
    public int findCircleNum(int[][] isConnected) {
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    dfs(isConnected, i);
                    count++;
                }
            }
        }
        return count;
    }
}