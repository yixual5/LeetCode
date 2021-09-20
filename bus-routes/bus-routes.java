class Solution {
    public int numBusesToDestination(int[][] routes, int source, int target) {
        if (target < 0 || source < 0 || routes == null || routes.length == 0) return -1;
        if (source == target) return 0;
        Map<Integer, Set<Integer>> bus_routes = new HashMap<>();
        for (int i = 0; i < routes.length; i++) {
            for (int bus_station : routes[i]) {
                bus_routes.computeIfAbsent(bus_station, k -> new HashSet<>()).add(i);
            }
        }
        int step = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.add(source);
        Set<Integer> seen = new HashSet<>();
        boolean[] visited_station = new boolean[routes.length];
        while (!q.isEmpty()) {
            step++;
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                int bus_station = q.poll();
                seen.add(bus_station);
                for (int j: bus_routes.get(bus_station)) {
                    if (visited_station[j]) continue;
                    for (int nxt : routes[j]) {
                        if (nxt == target) return step;
                        if (seen.contains(nxt)) continue;
                        q.offer(nxt);
                    }
                    visited_station[j] = true;
                }
            }
        }
        return -1;
    }
}