//priority queue to keep first 5
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

//sort first
class Solution {
    public int[][] highFive(int[][] items) {
        Arrays.sort(items, new Comparator<int[]>() {
            @Override
            public int compare(int[] a, int[] b) {
                if (a[0] == b[0]) {
                    return b[1] - a[1];
                } else {
                    return a[0] - b[0];
                }
            }
        });
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < items.length; i++) {
            int id = items[i][0];
            int count = 0;
            for (int j = i; j < i + 5; j++) {
                count += items[j][1];
            }
            result.add(new int[]{id, count / 5});
            while (i < items.length && items[i][0] == id) i++;
            i--;
        }
        int[][] solution = new int[result.size()][];
        return result.toArray(solution);
    }
}
