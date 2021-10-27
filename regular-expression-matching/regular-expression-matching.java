class Solution {
    public boolean isMatch(String s, String p) {
        
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        dp[0][0] = true;
        for (int i = 2; i < dp[0].length; i += 2) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = dp[0][i - 2];
            } else {
                break;
            }
        }
        for (int i = 1; i <= p.length(); i++) {
            for (int j = 1; j <= s.length(); j++) {
                char c = p.charAt(i - 1);
                if (c == '.') {
                    dp[j][i] = dp[j - 1][i - 1];
                } else if (c == '*') {
                    if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') {
                        dp[j][i] = dp[j - 1][i - 2] || dp[j][i - 2] || dp[j - 1][i];
                    } else {
                        dp[j][i] = dp[j][i - 2];
                    }
                } else if (c == s.charAt(j - 1)) {
                    dp[j][i] = dp[j - 1][i - 1];
                }
            }
        }
        return dp[s.length()][p.length()];
    }
}