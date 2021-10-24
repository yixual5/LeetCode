class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int tolerance = 0, up = 0, down = 0, res = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                up++;
                tolerance = up;
                down = 0;
                //first one is 1, so second is 1 + up
                res += 1 + up;
            } else if (ratings[i] == ratings[i - 1]) {
                res++;
                // reset all because we can not decrease anymore
                tolerance = up = down = 0;
            } else {
                down++;
                up = 0;
                res += down;
                //increase tolerance to keep decreasing
                if (down > tolerance) res++;
            }
        }
        return res;
    }
}