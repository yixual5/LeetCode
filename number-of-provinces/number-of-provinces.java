//dfs
class Solution {
    public int findCircleNum(int[][] isConnected) {
        boolean[] visited = new boolean[isConnected.length];
        
        int count = 0;
        for (int i = 0; i < isConnected.length; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, i);
                count++;
            }
        }
        return count;
        
    }
    
    private void dfs(int[][] isConnected, boolean[] visited, int idx) {
        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[idx][i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(isConnected, visited, i);
            }
        }
    }
}

//union find with rank and compression
class Solution {
    class UnionFind{
        int[] rank;
        int[] parent;
        int count;
        public UnionFind(int n) {
            count = n;
            rank = new int[n];
            parent = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
                rank[i] = 1;
            }
        }
        
        public int find(int i) {
            while (parent[i] != i) {
                //compression
                parent[i] = parent[parent[i]];
                i = parent[i];
            }
            return i;
        }
        
        public void union(int i, int j) {
            int rooti = find(i);
            int rootj = find(j);
            if (rooti == rootj) return;
            if (rank[rooti] > rank[rootj]) {
                rank[rooti] += rank[rootj];
                parent[rootj] = parent[rooti];
            } else {
                rank[rootj] += rank[rooti];
                parent[rooti] = parent[rootj];
            }
            count--;
        }
        
    }
    
    public int findCircleNum(int[][] isConnected) {
        UnionFind uf = new UnionFind(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = i + 1; j < isConnected[0].length; j++) {
                if (isConnected[i][j] == 1) uf.union(i, j);
            }
        }
        return uf.count;
    }
    
}
