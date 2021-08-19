class Solution {

    List<String> result;
    public List<String> wordBreak(String s, List<String> wordDict) {
        this.result = new ArrayList<>(); 
        backtracking(0, s, new StringBuffer(), wordDict);
        return result;
    }
    
    private void backtracking(int idx, String s, StringBuffer sb, List<String> wordDict) {
        if (idx == s.length()) {
            result.add(sb.toString().substring(0, sb.length() - 1));
            return;
        } else {
            for (String word : wordDict) {
                if (idx + word.length() <= s.length() && (s.substring(idx, idx + word.length()).equals(word))) {
                    sb.append(word + " ");
                    backtracking(idx + word.length(), s, sb, wordDict);
                    sb.setLength(sb.length() - word.length() - 1);
                }
            }
        }
    }
}