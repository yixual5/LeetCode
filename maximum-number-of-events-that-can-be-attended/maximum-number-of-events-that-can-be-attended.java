class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int idx = 0;
        int res = 0;
        for (int i = 1; i <= 100000; i++) {
            while (idx < events.length && events[idx][0] == i) pq.offer(events[idx++][1]);
            
            // expire events
            while (!pq.isEmpty() && pq.peek() < i) pq.poll();
            
            if (!pq.isEmpty()) {
                res++;
                pq.poll();
            }
        }
        return res;
    }
}