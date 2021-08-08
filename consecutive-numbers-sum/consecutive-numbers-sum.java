// 40 mins
class Solution {
    public int consecutiveNumbersSum(int n) {
        int result = 0;
        int bound = (int) (Math.sqrt(2 * n + 0.25) - 0.5);
        for (int k = 1; k <= bound; ++k) {
            n -= k;
            if (n % k == 0) result++;
        }
        return result;
    }
}
