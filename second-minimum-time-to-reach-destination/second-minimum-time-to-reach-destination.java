class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        int[] dist = new int[n];
        int[] visited = new int[n];
        dist[0] = 0;
        List<List<Integer>> adList = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            adList.add(new LinkedList<>());
        }
        
        for (int[] edge : edges) {
            adList.get(edge[0] - 1).add(edge[1] - 1);
            adList.get(edge[1] - 1).add(edge[0] - 1);
        }
        
        for (int i = 0; i < dist.length; i++) dist[i] = Integer.MAX_VALUE;
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{0, 0});
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            int vertex = temp[0];
            int dis = temp[1];
            if (dist[vertex] != Integer.MAX_VALUE && dis > dist[vertex] && vertex == n - 1) {
                return dis;
            }
            
            if (dist[vertex] == Integer.MAX_VALUE) dist[vertex] = dis;
            else if (visited[vertex] == 2 || dis == dist[vertex]) continue;
            visited[vertex]++;
            
            int cycle = dis / change;
            dis = cycle % 2 == 1 ? (cycle + 1) * change : dis;
            for (int neighbor : adList.get(vertex)) {
                
                if (visited[neighbor] < 2) q.offer(new int[]{neighbor, dis + time});
            }
            
        }
        
        return -1;
        
    }
}