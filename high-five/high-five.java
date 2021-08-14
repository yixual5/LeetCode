class Solution {
    public int[][] highFive(int[][] items) {
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
        for (int[] item : items) {
            map.computeIfAbsent(item[0], k -> new PriorityQueue<>()).offer(item[1]);
            if (map.get(item[0]).size() > 5) map.get(item[0]).poll();
        }
        int[][] result = new int[map.size()][2];
        int idx = 0;
        for (Map.Entry<Integer, PriorityQueue<Integer>> entry: map.entrySet()) {
            result[idx][0] = entry.getKey();
            PriorityQueue<Integer> q = entry.getValue();
            double temp = 0;
            while (!q.isEmpty()) temp += q.poll();
            result[idx++][1] =(int) (temp / 5.0);
        }
        return result;
    }
}