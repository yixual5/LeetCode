class Solution {
    // brute force
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        for (int i = 0; i < height.length; i++) {
            int mleft = 0;
            int mright = 0;
            for (int j = 0; j <= i; j++) {
                mleft = mleft < height[j] ? height[j] : mleft;
            }
            for (int j = i; j < height.length; j++) {
                mright = mright < height[j] ? height[j] : mright;
            }
            ans += Math.min(mleft, mright) - height[i];
        }
        return ans;
    }
}