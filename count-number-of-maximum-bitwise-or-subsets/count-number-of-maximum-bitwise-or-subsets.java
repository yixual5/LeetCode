class Solution {
    public int countMaxOrSubsets(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        //dp[i] is the # of sets who have OR value = i
        int[] dp = new int[1 << 17]; //10^5 approximaltey = 2^17
        dp[0] = 1;
        int max = 0;
        for (int num : nums) {
            for (int i = max; i >= 0; i--) {
                // adding one element in the set will add number of subset (i) to the nwe max 
                dp[num | i] += dp[i];
            }
            max |= num;
        }
        return dp[max];
    }
}