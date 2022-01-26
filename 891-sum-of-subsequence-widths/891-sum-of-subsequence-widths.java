class Solution {
    public int sumSubseqWidths(int[] nums) {
        long res = 0;
        long pow = 1;
        long mod = (long) 1e9 + 7;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++, pow = pow * 2 % mod) {
            res = (res + pow * nums[i] - pow * nums[nums.length - 1 - i]) % mod;
        }
        return (int) res;
    }
}