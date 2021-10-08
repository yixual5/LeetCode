class Solution {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        if (boxTypes == null || boxTypes.length == 0 || truckSize == 0) return 0;
        PriorityQueue<int[]> q = new PriorityQueue<>((k1, k2) -> k2[1] - k1[1]);
        for (int[] boxType : boxTypes) q.offer(boxType);
        int res = 0;
        while (truckSize > 0 && !q.isEmpty()) {
            int[] temp = q.poll();
            if (temp[0] > truckSize) {
                res += temp[1] * truckSize;
            } else {
                res += temp[1] * temp[0];
            }
            truckSize -= temp[0];
        }
        return res;
    }
}