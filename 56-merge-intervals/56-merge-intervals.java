class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a1, a2) -> a1[0] - a2[0]);
        List<int[]> res = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] cur = intervals[i];
            if (cur[0] <= prev[1]) prev[1] = Math.max(prev[1], cur[1]);
            else {
                res.add(prev);
                prev = cur;
            }
        }
        res.add(prev);
        return res.toArray(new int[res.size()][]);
    }
}