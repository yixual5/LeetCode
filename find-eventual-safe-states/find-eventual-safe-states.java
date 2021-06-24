class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> result = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        List<List<Integer>> rdirectedGraph = new ArrayList<>();
        List<List<Integer>> directedGraph = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            rdirectedGraph.add(new ArrayList<>());
            directedGraph.add(new ArrayList<>());
        }
        for (int i = 0; i < graph.length; i++) {
            
            if (graph[i].length == 0) {
                q.offer(i);
                
                continue;
            }
            for (int j : graph[i]) {
                directedGraph.get(i).add(j);
                rdirectedGraph.get(j).add(i);
            }
        }
        
        while (!q.isEmpty()) {
            int temp = q.poll();
            result.add(temp);
            for (Integer i : rdirectedGraph.get(temp)) {
                directedGraph.get(i).remove((Integer) new Integer(temp));
                if (directedGraph.get(i).size() == 0) q.offer(i);
            }
        }
        Collections.sort(result);
        return result;
    }
    
    
}

//dfs
class Solution {
    List<Integer> result = new ArrayList<>();
    public List<Integer> eventualSafeNodes(int[][] graph) {
        
        if (graph == null || graph.length == 0) return result;
        int[] safe = new int[graph.length];
        for (int i = 0; i < graph.length; i++) {
            if (dfs(i, graph, safe)) result.add(i);
        }
        return result;
    }
    
    private boolean dfs(int i, int[][] graph, int[] safe) {
        if (safe[i] == 2) return true;
        if (safe[i] == 1) return false;
        safe[i] = 1;
        for (int j : graph[i]) {
            if (!dfs(j, graph, safe)) {
                
                return false;
            }
            
        }
        safe[i] = 2;
        return true;
    }
}
