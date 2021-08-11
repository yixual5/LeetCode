// doesn't have too much thoughts at begining, 40 mins
class WordDistance {
    private Map<String, List<Integer>> map = new HashMap<>();
    public WordDistance(String[] wordsDict) {
        for (int i = 0; i < wordsDict.length; i++) {
            map.computeIfAbsent(wordsDict[i], k -> new ArrayList<>()).add(i);
        }
    }
    
    public int shortest(String word1, String word2) {
        List<Integer> l1 = map.get(word1);
        List<Integer> l2 = map.get(word2);
        int pointer1 = 0;
        int pointer2 = 0;
        int result = Integer.MAX_VALUE;
        while (pointer1 < l1.size() && pointer2 < l2.size()) {
            if (l1.get(pointer1) > l2.get(pointer2)) {
                result = Math.min(Math.abs(l1.get(pointer1) - l2.get(pointer2++)), result);
            } else if (l1.get(pointer1) < l2.get(pointer2)) {
                result = Math.min(Math.abs(l1.get(pointer1++) - l2.get(pointer2)), result);
            } else {
                return 0;
            }
        }
        return result;
    }
}

/**
 * Your WordDistance object will be instantiated and called as such:
 * WordDistance obj = new WordDistance(wordsDict);
 * int param_1 = obj.shortest(word1,word2);
 */
