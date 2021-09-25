class Solution {
    public int maxPoints(int[][] points) {
        if (points == null || points.length == 0) return 0;
        int mx = 0;
        for (int i = 0; i < points.length; i++) {
            Map<String, Integer> count = new HashMap<>();
            int max = 0;
            int overlap = 0;
            for (int j = i + 1; j < points.length; j++) {
                int x = points[j][0] - points[i][0];
                int y = points[j][1] - points[i][1];
                if (x == 0 && y == 0) {
                    overlap++;
                    continue;
                }
                int gcd = findgcd(x, y);
                x /= gcd;
                y /= gcd;
                String s = x + "," + y;
                count.put(s, count.getOrDefault(s, 0) + 1);
                max = Math.max(max, count.get(s));
            }
            mx = Math.max(max + overlap + 1, mx);
        }
        return mx;
    }
    
    //eculidean algorithm
    // gcd(a,b) = gcd(a, a-b)
    // check y because dibide by y first
    private int findgcd(int x, int y) {
        if (y == 0) return x;
        return findgcd(y, x % y);
    }
}