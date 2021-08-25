class TweetCounts {
    
    class TreeNode{
        TreeNode left;
        TreeNode right;
        int val;
        
        public TreeNode(int val) {
            this.val = val;
        }
    }
    
    Map<String, TreeNode> record;
    public TweetCounts() {
        this.record = new HashMap<>();
    }
    
    private TreeNode insert(TreeNode root, int val) {
        if (root == null) {
            root = new TreeNode(val);
        } else if (root.val <= val) { //include = for search boundary
            root.right = insert(root.right, val);
        } else {
            root.left = insert(root.left, val);
        }
        return root;
    }
    
    private int binarySearch(TreeNode root, int l, int r) {
        if (root == null) return 0;
        if (root.val <= l) {
            int count = root.val == l ? 1 : 0;
            return count + binarySearch(root.right, l, r);
        } else if (root.val >= r) {
            return binarySearch(root.left, l, r);
        } else {
            return 1 + binarySearch(root.left, l, r) + binarySearch(root.right, l, r);
        }
    }
    
    public void recordTweet(String tweetName, int time) {
        record.put(tweetName, insert(record.getOrDefault(tweetName, null), time));
    }
    
    public List<Integer> getTweetCountsPerFrequency(String freq, String tweetName, int startTime, int endTime) {
        List<Integer> result = new ArrayList<>();
        if (!record.containsKey(tweetName)) return result;
        TreeNode node = record.get(tweetName);
        int count = 0;
        if (freq.equals("minute")) count = 60;
        else if (freq.equals("hour")) count = 3600;
        else count = 86400;
        
        
        while (startTime + count <= endTime) {
            result.add(binarySearch(node, startTime, startTime + count));
            startTime += count;
        }
        if (startTime <= endTime) result.add(binarySearch(node, startTime, endTime + 1));
        return result;
    }
}

/**
 * Your TweetCounts object will be instantiated and called as such:
 * TweetCounts obj = new TweetCounts();
 * obj.recordTweet(tweetName,time);
 * List<Integer> param_2 = obj.getTweetCountsPerFrequency(freq,tweetName,startTime,endTime);
 */