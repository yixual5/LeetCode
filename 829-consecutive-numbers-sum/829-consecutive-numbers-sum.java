class Solution {
    public int consecutiveNumbersSum(int n) {
        int sum = 1;
        int res = 1;
        for (int i = 2; i < n; i++) {
            if (n - sum < i) return res;
            if ((n - sum) % i == 0) res++;
            sum += i;
        }
        return res;
    }
}