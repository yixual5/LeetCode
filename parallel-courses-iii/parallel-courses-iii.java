class Solution {
    public int minimumTime(int n, int[][] relations, int[] time) {
        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        int[] degrees = new int[n];
        for (int[] relation : relations) {
            graph.get(relation[0] - 1).add(relation[1] - 1);
            degrees[relation[1] - 1]++;
        }
        
        PriorityQueue<int[]> q = new PriorityQueue<>((a1, a2) -> a1[1] - a2[1]);
        for (int i = 0; i < degrees.length; i++) {
            if (degrees[i] == 0) q.offer(new int[]{i, time[i]});
        }
        int min = 0;
        while (!q.isEmpty()) {
            int[] temp = q.poll();
            for (Integer child : graph.get(temp[0])) {
                degrees[child]--;
                if (degrees[child] == 0) q.offer(new int[]{child, temp[1] + time[child]});
            }
            min = Math.max(temp[1], min);
        }
        return min;
    }
}