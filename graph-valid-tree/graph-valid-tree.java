class Solution {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, List<Integer>> graph = new HashMap<>();
    List<List<Integer>> ajList= new ArrayList<>();
    public boolean validTree(int n, int[][] edges) {
        
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