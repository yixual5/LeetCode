class Solution {
    public boolean reachingPoints(int sx, int sy, int tx, int ty) {
        while (sx < tx && sy < ty) {
            if (tx > ty) {
                tx %= ty;
            } else {
                ty %= tx;
            }
        }
        return (tx == sx && ty == sy) || (tx == sx && ty > sy && (ty - sy) % sx == 0) || (ty == sy && tx > sx && (tx - sx) % sy == 0);
    }
}