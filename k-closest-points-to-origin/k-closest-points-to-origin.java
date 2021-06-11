// heap comes to my mind at very first
class Solution {
    public int[][] kClosest(int[][] points, int k) {
        if (points == null) return null;
        PriorityQueue<int[]> heap = new PriorityQueue<>((n1, n2) ->Long.compare((n2[0]*n2[0] + n2[1]*n2[1]), (n1[0]*n1[0] + n1[1]*n1[1])));
        int[][] nkpoints = new int[k][2];
        for (int i = 0; i < points.length; i++) {
            heap.add(points[i]);
            if (heap.size() > k) heap.poll();
            
        }
        for (int i = 0; i < k; i++) {
            nkpoints[i] = heap.poll();
            
        }
        return nkpoints;
    }
}
