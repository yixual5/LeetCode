//Trie
class AutocompleteSystem {
    class Trie implements Comparable<Trie>{
        int times = 0;
        Trie[] children = new Trie[27];
        List<Trie> hot = new ArrayList<>();
        String s = null;
        
        public int compareTo(Trie t) {
            if (this.times == t.times) {
                return this.s.compareTo(t.s);
            }
            return t.times - this.times; //desceding
        }
        
        public void add(Trie t) {
            if (!hot.contains(t)) {
                hot.add(t);
            }
            Collections.sort(hot);
            if (hot.size() > 3) hot.remove(hot.size() - 1);
        }
    }
    
    Trie root;
    Trie cur;
    StringBuffer sb;
    public AutocompleteSystem(String[] sentences, int[] times) {
        sb = new StringBuffer();
        root = new Trie();
        cur = root;
        for (int i = 0; i < sentences.length; i++) {
            addS(sentences[i], times[i]);
        }
    }
    
    public void addS(String s, int times) {
        Trie node = root;
        List<Trie> visited = new ArrayList<>();
        for (char c : s.toCharArray()) {
            if (node.children[getIdx(c)] == null) {
                node.children[getIdx(c)] = new Trie();
            }
            node = node.children[getIdx(c)];
            visited.add(node);
        }
        node.times += times;
        node.s = s;
        for (Trie t : visited) {
            t.add(node);
        }
    }
    
    public List<String> input(char c) {
        List<String> result = new ArrayList<>();
        if (c == '#') {
            addS(sb.toString(), 1);
            cur = root;
            sb = new StringBuffer();
            return result;
        }
        sb.append(c);
        int idx = getIdx(c);
        if (cur != null) {
            cur = cur.children[idx];
        }
        if (cur != null) for (Trie t : cur.hot) result.add(t.s);
                
        return result;
    }
    
    
    public int getIdx(char c) {
        return c == ' ' ? 26 : c - 'a';
    }
}

/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
