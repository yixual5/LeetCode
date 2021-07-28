class Solution {
    Boolean[] visited;
    String s;
    public boolean wordBreak(String s, List<String> wordDict) {
        this.visited = new Boolean[s.length()];
        return backtracking(0, wordDict, s);
    }
    
    private boolean backtracking(int idx,  List<String> wordDict, String s) {
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