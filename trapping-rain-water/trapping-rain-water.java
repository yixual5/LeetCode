// brute force
class Solution {
    
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

//dp
class Solution {
    
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int[] mleft = new int[height.length];
        int[] mright = new int[height.length];
        mleft[0] = height[0];
        for (int i = 1; i < height.length; i++) {
            mleft[i] = Math.max(mleft[i - 1], height[i]);
            
        }
        mright[mright.length - 1] = height[height.length - 1];
        for (int i = mright.length - 2; i >= 0; i--) {
            mright[i] = Math.max(mright[i + 1], height[i]);
        }
        for (int i = 0; i < height.length; i++) {
            ans += Math.min(mleft[i], mright[i]) - height[i];
        }
        return ans;
    }
}

//two-pointer
class Solution {
    
    public int trap(int[] height) {
        if (height == null || height.length == 0) return 0;
        int ans = 0;
        int mleft = height[0];
        int mright = height[height.length - 1];
        int lpointer = 0;
        int rpointer = height.length - 1;
        while (lpointer < rpointer) {
            if (mleft < mright) {
                ans += mleft - height[lpointer++];
                mleft = Math.max(mleft, height[lpointer]);
                
                
            } else {
                ans += mright - height[rpointer--];
                mright = Math.max(mright, height[rpointer]);
            }
        }
        
        
        
        return ans;
    }
}
