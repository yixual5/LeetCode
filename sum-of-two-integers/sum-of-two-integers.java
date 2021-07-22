// 50 mins, hard to understand the minus operation

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

//without mutliple to check sign, still hard to understand it
class Solution {
    public int getSum(int a, int b) {

        while (b != 0) {
            int temp = a ^ b;
            int borrow = (a & b) << 1;
            a = temp;
            b = borrow;
        }

        return a;
    }
}
