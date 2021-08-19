class Solution {
    public int videoStitching(int[][] clips, int time) {
        int[] ranges = new int[time + 1];
        for (int[] clip : clips) {
            if (clip[0] < time) ranges[clip[0]] = Math.max(ranges[clip[0]], clip[1]);
        }
        int count = 1, next = 0, curEnd = ranges[0];
        if (curEnd == 0) return -1;
        if (curEnd >= time) return 1;
        for (int i = 1; i < time; i++) {
            if (i > curEnd) return -1;
            next = Math.max(ranges[i], next);
            if (next >= time) return count + 1;
            if (i == curEnd) {
                count++;
                curEnd = next;
            }
        }
        return -1;
    }
}