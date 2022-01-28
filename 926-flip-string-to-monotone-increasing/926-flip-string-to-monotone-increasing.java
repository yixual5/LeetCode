class Solution {
    Integer[][] dp;
    public int minFlipsMonoIncr(String s) {
        dp = new Integer[s.length()][2];
        return dfs(0, s, '0');
    }
    
    private int dfs(int idx, String s, char prev) {
        if (idx == s.length()) return 0;
        char cur = s.charAt(idx);
        if (dp[idx][prev - '0'] != null) return dp[idx][prev - '0'];
        int res = 0;
        if (prev == '1') {
            res = cur != prev ? 1 + dfs(idx + 1, s, prev) : dfs(idx + 1, s, prev);
        } else {
            res = Math.min(dfs(idx + 1, s, prev) + (cur == prev ? 0 : 1), dfs(idx + 1, s, '1') + (cur == '1' ? 0 : 1));
        }
        return dp[idx][prev - '0'] = res;
    }
}