//split into two subset, let their sum be close to total sum / 2
class Solution {
    public int lastStoneWeightII(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        int sum = 0;
        for (int stone : stones) sum += stone;
        int target = sum / 2;
        boolean[] dp = new boolean[target + 1];
        dp[0] = true;
        for (int i = 1; i <= stones.length; i++) {
            for (int j = target; j >= stones[i - 1]; j--) {
                dp[j] |= dp[j - stones[i - 1]]; 
            }
        }
        int result = 0;
        for (int i = 0; i <= target; i++) {
            if (dp[i]) result = i;
        }
        
        return sum - 2*result;
    }
}
