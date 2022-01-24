class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) graph.add(new LinkedList<Integer>());
        int[] degrees = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            graph.get(prerequisite[1]).add(prerequisite[0]);
            degrees[prerequisite[0]]++;
        }
        Queue<Integer> q = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) if (degrees[i] == 0) q.offer(i);
        List<Integer> order = new ArrayList<>();
        while (!q.isEmpty()) {
            int cur = q.poll();
            order.add(cur);
            for (Integer i : graph.get(cur)) {
                degrees[i]--;
                if (degrees[i] == 0) q.offer(i);
                
            }
        }
        if (order.size() != numCourses) return new int[0];
        int[] res = new int[numCourses];
        for (int i = 0; i < numCourses; i++) res[i] = order.get(i);
        return res;
    }
}