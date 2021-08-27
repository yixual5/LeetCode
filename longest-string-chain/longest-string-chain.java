class Solution {
    Map<String, Integer> memo = new HashMap<>();
    Set<String> s;
    public int longestStrChain(String[] words) {
        //Arrays.sort(words, (a, b) -> a.length() - b.length());
        
        s = new HashSet<String>(Arrays.asList(words));
        int max = 0;
        for (String word : words) {
            max = Math.max(dfs(word), max);
        }
        return max;
    }
    
    private int dfs(String word) {
        if (memo.containsKey(word)) return memo.get(word);
        StringBuffer sb = new StringBuffer(word);
        int count = 1;
        for (int i = 0; i < word.length(); i++) {
            sb.deleteCharAt(i);
            String ss = sb.toString();
            if (s.contains(ss)) {
                count = Math.max(dfs(ss) + 1, count);
            }
            sb.insert(i, word.charAt(i));
        }
        memo.put(word, count);
        return count;
    }
}