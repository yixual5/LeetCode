class Solution {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) return 0;
        int[] dp = new int[s.length()];
        int mx = Integer.MIN_VALUE;
        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = dp[i - 2 < 0 ? 0 : i - 2] + 2;
                } else if (i - dp[i - 1] - 1 >= 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - dp[i - 1] - 2 >= 0 ? i - dp[i - 1] - 2 : 0] + dp[i - 1] + 2;
                }
                mx = Math.max(mx, dp[i]);
                
            }
        }
        return mx == Integer.MIN_VALUE ? 0 : mx;
    } 
}