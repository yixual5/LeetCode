class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        if (!dict.contains(endWord)) return 0;
        Set<String> beginSet = new HashSet<>();
        beginSet.add(beginWord);
        Set<String> endSet = new HashSet<>();
        endSet.add(endWord);
        return move(beginSet, endSet, dict, 1);
    }
    
    private int move(Set<String> beginSet, Set<String>endSet, Set<String> dict, int level) {
        if (beginSet.size() == 0 || endSet.size() == 0) return 0;
        dict.removeAll(beginSet);
        level++;
        Set <String> nextSet = new HashSet<>();
        for (String s: beginSet) {
            //if (endSet.contains(s)) return level;
            int len = s.length();
            char[] c = s.toCharArray();
            for (int i = 0; i < len; i++) {
                char origin = c[i];
                for (int j = 0; j < 26; j++) {
                    c[i] = (char)('a' + j);
                    String ns = new String(c);
                    if (endSet.contains(ns)) return level;
                    if (dict.contains(ns)) {
                        nextSet.add(ns);
                    }
                }
                
                c[i] = origin;
            }
        }
        return nextSet.size() > endSet.size() ? move(endSet, nextSet, dict, level): move(nextSet, endSet, dict, level);
    }
}