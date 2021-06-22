class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<List<Integer>> ajList= new ArrayList<>();
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) return false;
        for (int i = 0; i < n; i++) {
            ajList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            ajList.get(edge[0]).add(edge[1]);
            ajList.get(edge[1]).add(edge[0]);
        }
        return cycleDetection(0, -1) && visited.size() == n;
    }
    
    private boolean cycleDetection(int node, int parents) {
        if (visited.contains(node)) return false;
        visited.add(node);
        for(Integer i : ajList.get(node)) {
            if (parents == i) continue;
            if (!cycleDetection(i, node)) {
                return false;
            }
        }
        return true;
    }
}


// if we have n-1 edge and the graph is fully connected, then there is no cycle. 
class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<List<Integer>> ajList= new ArrayList<>();
    public boolean validTree(int n, int[][] edges) {
        if (edges == null || edges.length != n - 1) return false;
        for (int i = 0; i < n; i++) {
            ajList.add(new ArrayList<>());
        }
        for (int[] edge : edges) {
            ajList.get(edge[0]).add(edge[1]);
            ajList.get(edge[1]).add(edge[0]);
        }
        dfs(0);
        return visited.size() == n; //fully connected or not
    }
    
    private void dfs(int node) {
        if (visited.contains(node)) return;
        visited.add(node);
        for (Integer i : ajList.get(node)) {
            dfs(i);
        }
    }
}

//union find, first time to know this algorithm
class Solution {
    int[] parent;
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n - 1) return false;
        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;
        
        for (int[] edge : edges) {
            int rootA = findRoot(edge[0]);
            int rootB = findRoot(edge[1]);
            if (rootA == rootB) return false;
            parent[rootA] = rootB;
        }
        
        return true;
        
    }
    
    private int findRoot(int i) {
        int temp = i;
        while (parent[temp] != temp) {
            temp = parent[temp];
        }
        // shrink the tree
        while (parent[i] != temp) {
            int prev = parent[i];
            parent[i] = temp;
            i = prev;
        }
        return temp;
    }
   
}
