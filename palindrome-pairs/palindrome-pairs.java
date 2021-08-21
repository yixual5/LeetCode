class Solution {
    
    class Trie{
        int idx = -1;
        Trie[] child = new Trie[26];
        List<Integer> pal = new ArrayList<>();
        
        public Trie() {

        }
    }
    
    Trie root;
    
    public List<List<Integer>> palindromePairs(String[] words) {
        root = new Trie();
        for (int j = 0; j < words.length; j++) {
            char[] c = words[j].toCharArray();
            Trie node = root;
            for (int i = c.length - 1; i >= 0; i--) {
                if (isPalindrome(words[j], i, true)) node.pal.add(j);
                if (node.child[c[i] - 'a'] == null) {
                    node.child[c[i] - 'a'] = new Trie();
                }
                node = node.child[c[i] - 'a'];
            }
            node.idx = j;
        }
        List<List<Integer>> result = new ArrayList<>();
        for (int j = 0; j < words.length; j++) {
            char[] c = words[j].toCharArray();
            Trie node = root;
            for (int i = 0; i < c.length; i++) {
                if (isPalindrome(words[j], i, false) && node.idx != -1) {
                    result.add(Arrays.asList(j, node.idx));
                }
                
                if (node.child[c[i] - 'a'] != null) {
                    node = node.child[c[i] - 'a'];
                } else {
                    node = null;
                    break;
                }
                
            }
            if (node == null) continue;
            if (node.idx != -1 && node.idx != j) result.add(Arrays.asList(j, node.idx));
            if (node.pal.size() != 0) {
                    for (Integer k : node.pal) {
                        result.add(Arrays.asList(j, k));
                    }
            }
        }
        return result;
        
    }
    
    private boolean isPalindrome(String s, int idx, boolean reverse) {
        int left = reverse ? 0 : idx;
        int right = reverse ? idx : s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }
}