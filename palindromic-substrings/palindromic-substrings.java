class Solution {
    public int countSubstrings(String s) {
        boolean[][] dp = new boolean[s.length()][s.length()];
        int res = 0;
        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j <= i; j++) {
                boolean temp = s.charAt(i) == s.charAt(j);
                if (i - j > 2) {
                    dp[i][j] = temp && dp[i - 1][j + 1];
                } else {
                    dp[i][j] = temp;
                }
                if (dp[i][j]) res++;
            }
        }
        return res;
    }
}