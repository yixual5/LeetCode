class Solution {
    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Arrays.sort(words, (a1, a2) -> a1.length() - a2.length());
        Set<String> dict = new HashSet<>();
        List<String> res = new LinkedList<>();
        for (int i = 0; i < words.length; i++) {
            if (wordBreak(words[i], dict)) res.add(words[i]);
            dict.add(words[i]);
        }
        return res;
    }
    
    private boolean wordBreak(String s, Set<String> dict) {
        if (dict.isEmpty()) return false;
        // end at index - 1
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (dp[j] && dict.contains(s.substring(j, i))) {
                    dp[i] = true; 
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}