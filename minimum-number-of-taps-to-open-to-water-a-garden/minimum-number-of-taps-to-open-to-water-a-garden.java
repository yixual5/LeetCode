class Solution {
    public int minTaps(int n, int[] ranges) {
        int[] distance = new int[n + 1];
        Arrays.fill(distance, -1);
        for (int i = 0; i < ranges.length; i++) {
            if (ranges[i] == 0) continue;
            int left = Math.max(i - ranges[i], 0);
            int right = Math.min(n, i + ranges[i]);
            distance[left] = Math.max(distance[left], right);
        }
        int next = 0, curEnd = distance[0], count = 1;
        if (curEnd >= n) return count;
        for (int i = 1; i < n; i++) {
            if (i > curEnd) return -1;
            next = Math.max(next, distance[i]);
            if (next >= n) return count + 1;
            if (i == curEnd) {
                count++;
                curEnd = next;
            }
        }
        return -1;
    }
}