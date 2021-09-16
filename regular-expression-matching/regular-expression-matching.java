class Solution {
    public boolean isMatch(String s, String p) {
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
        //backward moving
        int idx = p.length() - 1;
        dp[s.length()][p.length()] = true;
        //if s is at empty, we only can let them equal when we have *
        for(int j = p.length() - 2; j >= 0; j -= 2){
            if (p.charAt(j + 1) == '*') dp[s.length()][j] = dp[s.length()][j + 2];
        }
        
        for (int j = p.length() - 1; j >= 0; j--) {
            for (int i = s.length() - 1; i >= 0; i--) {
                if (j + 1 < p.length() && p.charAt(j + 1) == '*') {
                    dp[i][j] = ((p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && dp[i + 1][j]) || dp[i][j + 2]; // j+2 means skip num*, i+1 means increase num* by one
                } else {
                    dp[i][j] = (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) && dp[i + 1][j + 1];
                }
            }
        }
        return dp[0][0];
    }
}