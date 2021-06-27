class Solution {
    //sort begin and end
    public int minMeetingRooms(int[][] intervals) {
        if (intervals == null || intervals.length == 0) return 0;
        if (intervals.length == 1) return 1;
        int lent = intervals.length;
        int[] start = new int[lent];
        int[] end = new int[lent];
        int idx = 0;
        for (int[] i : intervals) {
            start[idx] = i[0];
            end[idx++] = i[1];
        }
        Arrays.sort(start);
        Arrays.sort(end);
        int p1;
        int p2 = 0;
        int count = 0;
        for (p1 = 0; p1 < lent; p1++) {
            if (start[p1] < end[p2]) {
                count++;
            } else {
                p2++;
            }
            
        }
        return count;
    }
}
