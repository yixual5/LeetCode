class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        // all possible combination of dic words end at idx i
        // return dp[s.length()]
        List<List<String>> dp = new ArrayList<List<String>>();
        Set<String> wordSet = new HashSet<>(wordDict);
        for (int i = 0; i < s.length(); i++) dp.add(new ArrayList<>());
        for (int i = 0; i < s.length(); i++) if (wordSet.contains(s.substring(0, i + 1))) dp.get(i).add(s.substring(0, i + 1));
        for (int i = 0; i < s.length(); i++) {
            for (int j = 1; j <= i; j++) {
                String right = s.substring(j, i + 1);
                if (wordSet.contains(right)) {
                    for (String ss : dp.get(j - 1)) dp.get(i).add(ss + " " + right);
                }
            }
        }
        return dp.get(dp.size() - 1);
        
    }
}