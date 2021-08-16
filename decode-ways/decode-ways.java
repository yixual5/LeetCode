class Solution {
    int[] memo;
    public int numDecodings(String s) {
        char[] stoc = s.toCharArray();
        memo = new int[stoc.length];
        return dfs(stoc, 0);

    }
    
    private int dfs(char[] stoc, int idx) {
        if (idx > stoc.length - 1) return 1;
        if (stoc[idx] == '0') return 0;
        if (memo[idx] != 0) return memo[idx];
        int count1 = dfs(stoc, idx + 1);
        int count2 = 0;
        if (idx + 1 < stoc.length) {
            if ((stoc[idx] - '0' == 2 && stoc[idx + 1] - '0' <= 6) || stoc[idx] - '0' == 1) count2 = dfs(stoc, idx + 2);
        }
        memo[idx] = count1 + count2;
        return memo[idx];
    }
}