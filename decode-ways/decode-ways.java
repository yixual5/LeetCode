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

//iterative
class Solution {
    
    public int numDecodings(String s) {
        if (s.length() == 0) return 0;

        char[] stoc = s.toCharArray();
        int[] memo = new int[stoc.length + 1];
        memo[0] = 1;
        memo[1] = stoc[0] == '0' ? 0 : 1;
        for (int i = 2; i <= stoc.length; i++) {
            if ((stoc[i - 2] - '0' == 2 && stoc[i - 1] - '0' <= 6) || stoc[i - 2] - '0' == 1) memo[i] += memo[i - 2];
            if (stoc[i - 1] != '0') memo[i] += memo[i - 1];
        }
        
        return memo[stoc.length];

    }
    
}
