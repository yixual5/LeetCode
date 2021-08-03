class WordDictionary {
    
    class TrieNode{
    
        TrieNode[] child;
        boolean isEnd = false;
    
        TrieNode(){
            this.child = new TrieNode[26];
        }
    }
    
    private TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    public void addWord(String word) {
        TrieNode node = root;
        for(char ch : word.toCharArray()){
            if (node.child[ch - 'a'] == null){
                node.child[ch - 'a'] = new TrieNode();
            }
            node = node.child[ch - 'a'];
        }
        node.isEnd = true;
    }
    
    private boolean dfs(String word, int idx, TrieNode node) {
        if (idx == word.length()) return node.isEnd;
        
        if (word.charAt(idx) == '.') {
            for (TrieNode t : node.child) {
                if (t != null && dfs(word, idx + 1, t)) return true;
            }
        } else if (node.child[word.charAt(idx) - 'a'] != null) {
            return dfs(word, idx + 1, node.child[word.charAt(idx) - 'a']);
        }
        return false;
    }
    
    public boolean search(String word) {
        return dfs(word, 0 , root);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */