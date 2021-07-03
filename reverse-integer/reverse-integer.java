class Solution {
    public int reverse(int x) {
        if (x == 0) return 0;
        int result = 0;
        while (x != 0) {
            int last = x % 10;
            x /= 10;
            if (result > Integer.MAX_VALUE / 10) return 0;
            // last digit of int max is 7
            if (result == Integer.MAX_VALUE / 10 && last > 7) return 0;
            if (result < Integer.MIN_VALUE / 10) return 0;
            // last digit is - 8
            if (result == Integer.MIN_VALUE / 10 && last < -8) return 0;
            result = result * 10 + last;
            
        }
        return result;
    }
}
