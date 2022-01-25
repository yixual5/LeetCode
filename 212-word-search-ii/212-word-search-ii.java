class Solution {
    
    class Trie{
        Trie[] children;
        String word;
        
        public Trie() {
            children = new Trie[26];
        }
        
        public boolean containsNode(char c) {
            return children[c - 'a'] != null;
        }
    }
    

    
    private Trie node = new Trie();
    private List<String> res = new LinkedList<>();
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) addWord(word);
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                backtracking(node, i, j, board);
            }
        }
        return res;
    }
    
    private void backtracking(Trie t, int i, int j, char[][] board) {
        if (t.word != null) {
            res.add(t.word);
            t.word = null;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || board[i][j] == '#' || !t.containsNode(board[i][j])) return;
        char temp = board[i][j];
        board[i][j] = '#';
        backtracking(t.children[temp - 'a'], i + 1, j, board);
        backtracking(t.children[temp - 'a'], i, j - 1, board);
        backtracking(t.children[temp - 'a'], i - 1, j, board);
        backtracking(t.children[temp - 'a'], i, j + 1, board);
        board[i][j] = temp;
    }
    
    public void addWord(String word) {
        Trie temp = node;
        for (char c : word.toCharArray()) {
            if (!temp.containsNode(c)) {
                temp.children[c - 'a'] = new Trie();
            }
            temp = temp.children[c - 'a'];
        }
        temp.word = word;
    }
    
}