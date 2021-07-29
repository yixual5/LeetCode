// with memorization backtracking O(n^3), 40 min
class Solution {
    Boolean[] visited;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.visited = new Boolean[s.length()];
        return backtracking(0, new HashSet<>(wordDict), s);
    }
    
    private boolean backtracking(int idx,  Set<String> wordDict, String s) {
        if (idx == s.length()) return true;
        if (visited[idx] != null) {
            return visited[idx];
        }
       for (int i = idx + 1; i <= s.length(); i++) {
           
           if (wordDict.contains(s.substring(idx, i)) && backtracking(i, wordDict, s)) {
               visited[idx] = true;
               return true;
           }
       }
        visited[idx] = false;
        return false;
    }
    
}

//add dp solution O(n^3), 30min
class Solution {

    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        Set<String> wd = new HashSet<>(wordDict);
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wd.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }
        return dp[s.length()];
    }
    
    
    
}
