class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] order = new int[numCourses];
        if (prerequisites == null || prerequisites.length == 0) {
            for (int i = 0; i < numCourses; i++) {
                order[i] = i;  
            }
            return order;
        }
        Map<Integer, Set<Integer>> graph = new HashMap<>();
        int[] depth = new int[numCourses];
        for (int[] pre : prerequisites) {
            graph.computeIfAbsent(pre[1], k -> new HashSet<>()).add(pre[0]);
            depth[pre[0]]++;
        }
        Queue<Integer> q = new LinkedList<>();
        int orderIndex = 0;
        for (int i = 0; i < numCourses; i++) {
            if (depth[i] == 0) {
                q.offer(i);
                order[orderIndex++] = i;
            }
        }
        while (!q.isEmpty()) {
            int cur = q.poll();
            if (!graph.containsKey(cur)) continue;
            Set<Integer> s = graph.get(cur);
            for (int i : s) {
                depth[i]--;
                if (depth[i] == 0) {
                    q.offer(i);
                    order[orderIndex++] = i;
                }
            }
        }
        if (orderIndex != numCourses) return new int[]{};
        return order;
    }
}