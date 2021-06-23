class Solution {
    // backtracking
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> result = new ArrayList<>();
        if (graph == null || graph.length == 0) return result;
        LinkedList<Integer> cur = new LinkedList<>();
        cur.add(0);
        backtracking(result, cur, 0, graph.length - 1, graph);
        return result;
    }
    
    private void backtracking(List<List<Integer>> result, LinkedList<Integer> cur, int node, int target,
                             int[][] graph) {
        if (node == target) {
            result.add((LinkedList) cur.clone());
            return;
        }
        for (int i : graph[node]) {
            cur.add(i);
            backtracking(result, cur, i, target, graph);
            cur.removeLast();
        }
    }
}
