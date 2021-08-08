// 1hr
class Solution {
    class TrieNode{
        String word;
        TrieNode[] child = new TrieNode[26];
        int size = 0;
        public TrieNode() {
            
        }
        
    }
    
    private TrieNode root = new TrieNode();
    private List<String> result = new ArrayList<>();
    private int[] x = new int[]{1, 0, 0, -1};
    private int[] y = new int[]{0, 1, -1, 0};
    
    public List<String> findWords(char[][] board, String[] words) {
        for (String word : words) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                if (node.child[c - 'a'] == null) {
                    node.child[c - 'a'] = new TrieNode();
                    node.size++;
                }
                node = node.child[c - 'a'];
            }
            node.word = word;
        }
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (root.child[board[i][j] - 'a'] != null) dfs(i, j, board, root);
            }
        }
        return result;
        
        
    }
    
    private void dfs(int i, int j, char[][] board, TrieNode node) {

        char c = board[i][j];
        TrieNode cur = node.child[c - 'a'];
        if (cur.word != null) {
            result.add(cur.word);
            cur.word = null;
        }
    
        board[i][j] = '#';
        
        for (int k = 0; k < 4; k++) {
            int col = j + x[k];
            int row = i + y[k];
            if (col >= 0 && col < board[0].length && row >= 0 && row < board.length && board[row][col] != '#' && cur.child[board[row][col] - 'a'] != null) {
                dfs(row, col, board, cur);
            }
        }
        
        board[i][j] = c;
        
        if (cur.size == 0) {
            node.child[c - 'a'] = null;
            node.size--;
        }
    }
}
