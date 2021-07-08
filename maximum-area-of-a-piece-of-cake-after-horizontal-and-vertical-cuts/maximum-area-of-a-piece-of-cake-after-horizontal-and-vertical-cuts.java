class Solution {
    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        int prev = 0;
        long hmax = 0;
        long wmax = 0;
        Arrays.sort(horizontalCuts);
        Arrays.sort(verticalCuts);
        for (int hh : horizontalCuts) {
            wmax = Math.max(hh - prev, wmax);
            prev = hh;
        }
        wmax = Math.max(h - prev, wmax);
        prev = 0;
        for (int ww : verticalCuts) {
            hmax = Math.max(ww - prev, hmax);
            prev = ww;
        }
        hmax = Math.max(w - prev, hmax);
        return (int) ((wmax * hmax) % (1000000007));
    }
}