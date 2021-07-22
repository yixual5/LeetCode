class Solution {
    public int getSum(int a, int b) {
        int x = Math.abs(a);
        int y = Math.abs(b);
        if (x < y) return getSum(b, a);
        int sign = a > 0 ? 1 : -1;
        if (a * b >= 0) {
            while (y != 0) {
                int temp = x ^ y;
                int borrow = (x & y) << 1;
                x = temp;
                y = borrow;
            }
        } else {
            while (y != 0) {
                int temp = x ^ y;
                int borrow = (~x & y) << 1;
                x = temp;
                y = borrow;
            }
        }
        return sign * x;
    }
}