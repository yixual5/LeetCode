class FileSystem {
    class Dir{
        Map<String, Dir> dir;
        Map<String, String> FileToContent;
        
        public Dir() {
            dir = new HashMap<>();
            FileToContent = new HashMap<>();
        }
    }
    
    Dir root;
    public FileSystem() {
        this.root = new Dir();
    }
    
    public List<String> ls(String path) {
        String[] s = path.split("/");
        List<String> result = new ArrayList<>();
        
        Dir d = this.root;
        if (s.length == 0) {
            result.addAll(d.dir.keySet());
            result.addAll(d.FileToContent.keySet());
            Collections.sort(result);
            return result;
        }
        for (int i = 1; i < s.length - 1; i++) {
            d = d.dir.get(s[i]);
        }
        if (d.FileToContent.containsKey(s[s.length - 1])) {
            result.add(s[s.length - 1]);
            return result;
        } else {
            d = d.dir.get(s[s.length - 1]);
            result.addAll(d.dir.keySet());
            result.addAll(d.FileToContent.keySet());
            Collections.sort(result);
            return result;
        }
    }
    
    public void mkdir(String path) {
        String[] s = path.split("/");
        Dir d = this.root;
        for (int i = 1; i < s.length; i++) {
            if (!d.dir.containsKey(s[i])) {
                d.dir.put(s[i], new Dir());
            }
            d = d.dir.get(s[i]);
        }
    }
    
    public void addContentToFile(String filePath, String content) {
        String[] s = filePath.split("/");
        Dir d = this.root;
        for (int i = 1; i < s.length - 1; i++) {
            d = d.dir.get(s[i]);
        }
        //last path is file name
        d.FileToContent.put(s[s.length - 1], d.FileToContent.getOrDefault(s[s.length - 1], "") + content);
        
    }
    
    public String readContentFromFile(String filePath) {
        String[] s = filePath.split("/");
        Dir d = this.root;
        for (int i = 1; i < s.length - 1; i++) {
            d = d.dir.get(s[i]);
        }
        return d.FileToContent.get(s[s.length - 1]);
    }
}

/**
 * Your FileSystem object will be instantiated and called as such:
 * FileSystem obj = new FileSystem();
 * List<String> param_1 = obj.ls(path);
 * obj.mkdir(path);
 * obj.addContentToFile(filePath,content);
 * String param_4 = obj.readContentFromFile(filePath);
 */