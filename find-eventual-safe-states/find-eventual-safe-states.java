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