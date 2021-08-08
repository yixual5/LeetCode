class Solution {
    private int[] w;
    private Random ran = new Random();
    public Solution(int[] w) {
        for (int i = 1; i < w.length; i++) {
            w[i] = w[i - 1] + w[i];
        }
        this.w = w;
    }
    
    public int pickIndex() {
        int val = ran.nextInt(w[w.length - 1]) + 1;
        int left = 0;
        int right = w.length;
        int mid = 0;
        while (left < right) {
            mid = left + (right - left) / 2;
            if (w[mid] >= val) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */