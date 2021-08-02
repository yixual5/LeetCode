class Trie {
    
    
    
    class TrieNode {
        private TrieNode[] child;
        private boolean end;
        
        public TrieNode() {
            child = new TrieNode[26];
        }
        
        public boolean check(char c) {
            return child[c - 'a'] != null;
        }
        
        public void put(char c, TrieNode node) {
            child[c - 'a'] = node;
        }
        
        public TrieNode get(char c) {
            return child[c - 'a'];
        }
        
        public void setEnd() {
            end = true;
        }
        
        public boolean isEnd() {
            return end;
        }
    }
    
    
    private TrieNode root;
    
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        char[] c = word.toCharArray();
        TrieNode temp = root;
        for (char i : c) {
            if (!temp.check(i)) {
                temp.put(i, new TrieNode());
            }
            temp = temp.get(i);
        }
        temp.setEnd();
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        char[] c = word.toCharArray();
        TrieNode temp = root;
        for (char i : c) {
            if (!temp.check(i)) {
                return false;
            }
            temp = temp.get(i);
        }
        
        return temp.isEnd();
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        char[] c = prefix.toCharArray();
        TrieNode temp = root;
        for (char i : c) {
            if (!temp.check(i)) {
                return false;
            }
            temp = temp.get(i);
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */