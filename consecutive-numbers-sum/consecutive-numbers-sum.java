class Solution {
    public int consecutiveNumbersSum(int n) {
        int result = 0;
        int upper_limit = (int)(Math.sqrt(2 * n + 0.25) - 0.5);
        for (int k = 1; k <= upper_limit; ++k) {
            n -= k;
            if (n % k == 0) result++;
        }
        return result;
    }
}