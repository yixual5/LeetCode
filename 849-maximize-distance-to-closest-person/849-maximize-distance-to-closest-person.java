class Solution {
    public int maxDistToClosest(int[] seats) {
        int prev = seats[0] == 1 ? 0 : -1;
        int dis = 0;
        for (int i = 1; i < seats.length; i++) {
            if (seats[i] == 1) {
                if (prev == -1) dis = i;
                else dis = Math.max(dis, (i - prev) / 2);
                prev = i;
            }
        }
        
        return Math.max(seats.length - 1 - prev, dis);
    }
}