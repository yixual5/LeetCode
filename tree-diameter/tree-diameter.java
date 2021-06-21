class Solution {
    private int lent = 0;
    private Map<Integer, List<Integer>> count = new HashMap<>();
    //
    public int treeDiameter(int[][] edges) {
        if (edges.length == 0) return 0;
        
        
        for (int[] edge : edges) {
            count.computeIfAbsent(edge[0], k -> new LinkedList<>()).add(edge[1]);
            count.computeIfAbsent(edge[1], k -> new LinkedList<>()).add(edge[0]);
        }
        boolean[] visited = new boolean[count.keySet().size()];
        //visited[0] = true;
        dfs(0, visited);
        return lent;
    }
    
    private int dfs (int curNode, boolean[] visited) {
        //if (visited[curNode]) return 0;
        visited[curNode] = true;
        int max1 = 0;
        int max2 = 0;
        for (Integer i : count.get(curNode)){
            
            if (visited[i]) continue;
            int temp = 1 + dfs(i, visited);
            if (temp > max1) {
                max2 = max1;
                max1 = temp;
            } else if (temp > max2) {
                max2 = temp;
            }
        }
        lent = Math.max(lent, max1 + max2);
        return max1;
        
    }
}
